package com.example.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // This annotation means that this class has 'bean' definition
public class ApplicationConfig {
    @Bean
    @Qualifier("bean1")
    public FirstClass FirstBean() {
        return new FirstClass("First Bean");
    }

    @Bean
    @Qualifier("bean2")
    public FirstClass SecondBean() {
        return new FirstClass("Second Bean");
    }

    @Bean
    @Primary
    public FirstClass ThirdBean() {
        return new FirstClass("Third Bean");
    }
}
