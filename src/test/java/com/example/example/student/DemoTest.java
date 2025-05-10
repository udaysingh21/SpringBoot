package com.example.example.student;

import org.junit.jupiter.api.*;

class DemoTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside Before All  Method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside After All  Method");
    }

    @BeforeEach // this would be execute before each test
    void setUp() {
        System.out.println("Inside Before Each Method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside After Each Method");
    }

    @Test
    public void testMethod1() {
        System.out.println("This is my first Test method");
    }

    @Test
    public void testMethod2() {
        System.out.println("This is my second Test method");
    }

}