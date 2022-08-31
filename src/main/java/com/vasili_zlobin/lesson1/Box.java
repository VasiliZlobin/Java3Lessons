package com.vasili_zlobin.lesson1;

import java.util.LinkedList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new LinkedList<>();
    private final String name;

    public Box(String name) {
        this.name = name;
    }

    public float getWeight() {
        float result = 0f;
        for (T fruit : fruits) {
            result += fruit.getWeight();
        }
        return result;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public boolean compare(Box<?> other) {
        float epsilon = 0.00000001f;
        return Math.abs(other.getWeight() - this.getWeight()) < epsilon;
    }

    public void moveFruitsToOtherBox(Box<T> other) {
        for (T fruit : fruits) {
            other.add(fruit);
        }
        fruits.clear();
    }

    public int count() {
        return fruits.size();
    }

    @Override
    public String toString() {
        return String.format("Box<%s>, Quantity = %d, Weight = %f", name, count(), getWeight());
    }
}