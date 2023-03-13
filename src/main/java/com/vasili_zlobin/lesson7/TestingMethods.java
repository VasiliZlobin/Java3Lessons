package com.vasili_zlobin.lesson7;

public class TestingMethods {

    @Test(priority = 1)
    public void printOne() {
        System.out.println("One. priority = 1");
    }

    @Test
    public void printTwo() {
        System.out.println("Two");
    }

    @Test
    public void printNine() {
        System.out.println("Nine");
    }

    @Test(priority = 4)
    public void printFour() {
        System.out.println("Four. priority = 4");
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
