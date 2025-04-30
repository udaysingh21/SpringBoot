package com.example.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

//    @Autowired // Field injection - this is not recommended , constructor injection or setter injection is recommended
//    @Qualifier("SecondBean")
    private FirstClass firstClass;

    @Autowired // Setter injection
    public void setFirstClass(@Qualifier("ThirdBean") FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    // Constructor Injection - This is the best and most recommended way to inject dependencies
//    @Autowired // needs to be on constructor level , spring will know that we need to fetch a bean of type FirstClass
//    public MyFirstService(FirstClass firstClass) {
//        this.firstClass = firstClass;
//    }

    public String tellStory() {
        return "The dependency is saying"+firstClass.sayHello();
    }
}
