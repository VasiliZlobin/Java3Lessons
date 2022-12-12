package com.vasili_zlobin.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Homework7 {
    private static final int MIN_PRIORITY = 10;
    public static void start(Class classTest) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = classTest.getDeclaredMethods();
        List<Method> collectBefore = Arrays.stream(methods)
                .filter((method) -> isAnnotation(method, BeforeSuite.class))
                .collect(Collectors.toList());
        if (collectBefore.size() > 1) {
            throw new RuntimeException("Много методов @BeforeSuite");
        }
        List<Method> collectAfter = Arrays.stream(methods)
                .filter((method) -> isAnnotation(method, AfterSuite.class))
                .collect(Collectors.toList());
        if (collectAfter.size() > 1) {
            throw new RuntimeException("Много методов @AfterSuite");
        }
        if (!collectBefore.isEmpty()) {
            collectBefore.get(0).invoke(classTest.getConstructors()[0].newInstance());
        }
        runMethodsTest(methods,classTest);
        if (!collectAfter.isEmpty()) {
            collectAfter.get(0).invoke(classTest.getConstructors()[0].newInstance());
        }
    }

    private static boolean isAnnotation(Method method, Class check) {
        return method.getDeclaredAnnotation(check) != null;
    }

    private static void runMethodsTest(Method[] methods, Class classTest) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Map<Integer, List<Method>> collect = Arrays.stream(methods)
                .filter((method) -> isAnnotation(method, Test.class))
                .collect(Collectors.groupingBy((method -> method.getAnnotation(Test.class).priority())));
        for (int i = 1; i <= MIN_PRIORITY; i++) {
            if (collect.containsKey(i)) {
                for (Method method : collect.get(i)) {
                    method.invoke(classTest.getConstructors()[0].newInstance());
                }
            }
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        start(TestingMethods.class);
    }
}
