package com.vasili_zlobin.lesson7;

public class TestingMethods {

    @Test(priority = 1)
    public void printOne() {
        System.out.println("One");
    }

    @Test
    public void printTwo() {
        System.out.println("Ten");
    }

    @Test
    public void printNine() {
        System.out.println("nine");
    }

    @Test(priority = 4)
    public void printFour() {
        System.out.println("Four");
    }

    @BeforeSuite
    public void before() {
        System.out.println("before");
    }

    @AfterSuite
    public void after() {
        System.out.println("after");
    }
}
