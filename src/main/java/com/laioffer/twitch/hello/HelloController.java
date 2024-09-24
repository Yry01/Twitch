package com.laioffer.twitch.hello;


import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//know this class needs to be scanned to see the
@RestController
public class HelloController {
    //maps all the relative path to use the function hello

    //if a parameter name is required, header should be public Person sayHello(@Parameter = true)String name)
    @GetMapping("/hello")
    public Person sayHello(@RequestParam(required = false) String name) {
        Faker faker = new Faker();
        if(name == null) {
            name = "guest";
        }
        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();

        return new Person(name, company, new Address(street, city, state, null), new Book(bookTitle, bookAuthor));

    }


    //if the same path map to the different function, error occurs
}