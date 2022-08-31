package com.vasili_zlobin.lesson1;

public class Orange extends Fruit {
    private static final float DEFAULT_WEIGHT = 1.5f;

    public Orange() {
        this(DEFAULT_WEIGHT);
    }

    public Orange(float weight) {
        super(weight);
    }

}
