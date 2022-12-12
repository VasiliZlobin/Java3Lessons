import com.vasili_zlobin.lesson7.ArrayWithoutNumberException;
import com.vasili_zlobin.lesson7.Homework6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Homework6Test {
    static Homework6 homework6;

    @BeforeEach
    void init() {
        homework6 = new Homework6();
    }

    @Test
    public void testGetArrayAfterLastNumber() {
        Assertions.assertArrayEquals(new int[]{1, 7}, homework6.getArrayAfterLastNumber(new int[]{1, 4, 5, 67, 4, 1, 7}));
    }

    @Test
    public void testGetArrayAfterLastNumberEnd4() {
        Assertions.assertArrayEquals(new int[]{}, homework6.getArrayAfterLastNumber(new int[]{1, 4, 5, 67, 4, 1, 4}));
    }

    @Test
    public void testGetArrayAfterLastNumberStart4() {
        Assertions.assertArrayEquals(new int[]{1, 5, 67, 3, 1, 6}, homework6.getArrayAfterLastNumber(new int[]{4, 1, 5, 67, 3, 1, 6}));
    }

    @Test
    public void testGetArrayAfterLastNumberException() {
        Assertions.assertThrows(ArrayWithoutNumberException.class, () -> homework6.getArrayAfterLastNumber(new int[]{1, 5, 67, 1, 7}));
    }

    @Test
    public void testArrayHasOnlyAllNumbers() {
        int[] array = new int[]{1, 1, 4, 1, 1};
        Assertions.assertTrue(homework6.arrayHasOnlyAllNumbers(array, Homework6.ARRAY_CHECK));
    }

    @Test
    public void testArrayHasOnlyAllNumbersOnly1() {
        int[] array = new int[]{1, 1, 1, 1, 1};
        Assertions.assertFalse(homework6.arrayHasOnlyAllNumbers(array, Homework6.ARRAY_CHECK));
    }

    @Test
    public void testArrayHasOnlyAllNumbersWith3() {
        int[] array = new int[]{1, 1, 4, 1, 3};
        Assertions.assertFalse(homework6.arrayHasOnlyAllNumbers(array, Homework6.ARRAY_CHECK));
    }

    @Test
    public void testArrayHasOnlyAllNumbersOnly4() {
        int[] array = new int[]{4, 4, 4, 4, 4};
        Assertions.assertFalse(homework6.arrayHasOnlyAllNumbers(array, Homework6.ARRAY_CHECK));
    }
}
