package com.vasili_zlobin.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework7 {

    public static void start(Class classTest) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = classTest.getDeclaredMethods();
        Method beforeSuite = null, afterSuite = null;
        for (Method method : methods) {
            if (isAnnotation(method, BeforeSuite.class)) {
                if (beforeSuite != null) {
                    throw new RuntimeException("Много методов @BeforeSuite");
                }
                beforeSuite = method;
            }
            if (isAnnotation(method, AfterSuite.class)) {
                if (afterSuite != null) {
                    throw new RuntimeException("Много методов @AfterSuite");
                }
                afterSuite = method;
            }
        }
        if (beforeSuite != null) {
            beforeSuite.invoke(classTest.getConstructors()[0].newInstance());
        }
        runMethodsTest(methods, classTest);
        if (afterSuite != null) {
            afterSuite.invoke(classTest.getConstructors()[0].newInstance());
        }
    }

    private static boolean isAnnotation(Method method, Class check) {
        return method.getDeclaredAnnotation(check) != null;
    }

    private static void runMethodsTest(Method[] methods, Class classTest) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for (Method method : methods) {
            if (isAnnotation(method, Test.class)) {
                method.invoke(classTest.getConstructors()[0].newInstance());
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        start(TestingMethods.class);
    }
}
