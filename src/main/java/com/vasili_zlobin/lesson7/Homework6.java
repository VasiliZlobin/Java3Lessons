package com.vasili_zlobin.lesson7;

import java.util.Arrays;

public class Homework6 {
    private static final int CHECK_NUMBER = 4;
    public static final int[] ARRAY_CHECK = new int[]{1, 4};

    public int[] getArrayAfterLastNumber(int[] array) {
        int position = -1;
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] == CHECK_NUMBER) {
                position = i;
                break;
            }
        }
        if (position == -1) {
            throw new ArrayWithoutNumberException(CHECK_NUMBER);
        }
        position++;
        if (position == array.length) {
            return new int[]{};
        }
        return Arrays.copyOfRange(array, position, array.length);
    }

    public boolean arrayHasOnlyAllNumbers(int[] array, int[] checkNumbers) {
        boolean result = true;
        for (int j : checkNumbers) {
            result = arrayHasNumber(array, j);
            if (!result) break;
        }
        if (result) {
            for (int i : array) {
                result = false;
                for (int j : checkNumbers) {
                    result = i == j;
                    if (result) break;
                }
                if (!result) break;
            }
        }
        return result;
    }

    private boolean arrayHasNumber(int[] array, int number) {
        boolean result = false;
        for (int i : array) {
            result = i == number;
            if (result) break;

        }
        return result;
    }
}
