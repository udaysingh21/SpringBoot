package com.example.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// run() returns the context of our app so we will store it.
		// It is like a container that holds all the beans(components) that spring manages.
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		//Here we are creating the object of FirstClass() manually , which is not a good practice.
		//Instead, we will create a bean class to instantiate the object.
		//FirstClass firstClass = new FirstClass();
		MyFirstService firstService = ctx.getBean(MyFirstService.class);
		System.out.println(firstService.tellStory());
		System.out.println(firstService.getJavaVersion());
		System.out.println(firstService.readProperties());
	}

	//  Converting this class to Bean class so it is fully managed by Spring Framework
	//  This is one way to create a Bean class - another way is to use Component annotation
	//  All this will be put in Configuration Class.
//	@Bean
//	public FirstClass FirstClass() {
//		return new FirstClass();
//	}


}
