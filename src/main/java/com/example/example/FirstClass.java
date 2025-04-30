package com.example.example;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component // This component will tell that this is a Bean class.
//@Service
//@Repository
// These are all markdown annotations that marks any object or class as Spring Bean
// Splitting the configuration is one of the best practices
public class FirstClass {

    private final String myvar;

    public FirstClass(String myvar) {
        this.myvar = myvar;
    }

    public String sayHello() {
        return "Hello , I am Uday Vikram Singh and this is my first bean called : "+myvar;
    }
}
