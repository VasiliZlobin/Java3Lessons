package com.vasili_zlobin.lesson7;

public class TestingMethods {

    @Test
    public void printOne() {
        System.out.println("One");
    }

    @Test
    public void printTwo() {
        System.out.println("Two");
    }

    @BeforeSuite
    public void before() {
        System.out.println("before");
    }
}
