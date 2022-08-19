package com.vasili_zlobin.lesson1;

public class Apple extends Fruit {
    private static final float DEFAULT_WEIGHT = 1f;

    public Apple() {
        this(DEFAULT_WEIGHT);
    }

    public Apple(float weight) {
        super(weight);
    }

}
