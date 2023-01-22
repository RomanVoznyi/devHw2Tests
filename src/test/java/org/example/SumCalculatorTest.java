package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {
    private SumCalculator calc;

    @BeforeEach
    public void beforeEach() {
        calc = new SumCalculator();
    }

    @Test
    public void testThatCalcWorksCorrectWith1() {
        //When
        int result = calc.sum(1);

        //Then
        int expected = 1;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcWorksCorrectWith5() {
        //When
        int result = calc.sum(5);

        //Then
        int expected = 15;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcThrowExceptionWith0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.sum(0);
        });
    }

    @Test
    public void testThatCalcWorksIncorrectWithInt100000() {
        //When
        int sumResult = calc.sum(100000);
        Boolean result = sumResult > 2147483647;  //max capacity of int type (sumResult should be 5000050000)

        //Then
        long expected = 5000050000l;

        Assertions.assertNotEquals(expected, result);
    }
}
