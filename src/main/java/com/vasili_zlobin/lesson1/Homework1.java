package com.vasili_zlobin.lesson1;

import java.util.Arrays;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[]{10, 70, 20, 1, 7};
        System.out.println(Arrays.toString(arrayInt));
        swapArrayElements(arrayInt, 0, 3);

        System.out.println(convertArrayToList(arrayInt).toString());

        testWork3();
    }

    private static void testWork3() {
        Box<Apple> boxApples = new Box<>("Apple1");
        Box<Orange> boxOranges = new Box<>("Orange1");
        Box<Orange> boxOrangesSecond = new Box<>("Orange2");
        for (int i = 0; i < 10; i++) {
            boxApples.add(new Apple((i + 1) * 0.15f));
            boxOranges.add(new Orange());
            boxOrangesSecond.add(new Orange());
        }
        System.out.println(boxApples);
        System.out.println(boxOranges);
        System.out.println(boxOrangesSecond.compare(boxOranges));
        boxOrangesSecond.moveFruitsToOtherBox(boxOranges);
        System.out.println(boxOranges);
        System.out.println(boxOrangesSecond);
    }

    private static <T> void swapArrayElements(T[] array, int firstIndex, int secondIndex) {
        boolean error = firstIndex < 0 || firstIndex >= array.length || secondIndex < 0 || secondIndex >= array.length;
        if (!error) {
            T temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
        }
    }

    private static <T> List<T> convertArrayToList(T[] array) {
        return Arrays.asList(array);
    }
}
