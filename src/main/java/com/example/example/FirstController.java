package com.example.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// Controller is a key component that handles HTTP request and defines how to handle them.
// It maps HTTP methods (GET,POST,PUT,DELETE,PATCH) TO Java methods using annotations like GETMAPPING,POSTMAPPING.
// It delegates Business Logic to Service Layers.


@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World !!";
    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED) // It is a good practice to mention Response Status
    public String sayHello2() {
        return "Hello World Everyone!!";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request Accepted and message is : "+message;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody orderdto order) {
        return "Request Accepted and message is : "+order.toString();
    }

    // Passing Paramter
    //http://localhost:8080/hello/user-name
    @GetMapping("/hello/{user-name}") // Always add @PathVariable annotation to variable name
    public String PathVar(@PathVariable("user-name") String uname) {
        return "My Name is "+uname;
    }

    // Passing Request Params
    //http://localhost:8080/helloparam?param-name=value&param_name2=value2
    @GetMapping("/helloparam") // Always add @PathVariable annotation to variable name
    public String ParamVar(@RequestParam("user-name") String fname, @RequestParam("user-lname ") String lname) {
        return "My Name is "+fname+" "+lname;
    }

}
