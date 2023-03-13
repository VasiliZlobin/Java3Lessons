package com.vasili_zlobin.lesson7;

public class ArrayWithoutNumberException extends RuntimeException{
    public ArrayWithoutNumberException(int number) {
        super(String.format("Ошибка. Массив должен содержать %d", number));
    }
}
