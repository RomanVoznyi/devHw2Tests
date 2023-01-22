package org.example;

import org.example.SumCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SumCalculatorTest {
    private SumCalculator calc;

    @BeforeEach
    public void beforeEach() {
        calc = new SumCalculator();
    }

    @Test
    public void testThatCalcWorksCorrectWithInt1() {
        //When
        int result = calc.sum(1);

        //Then
        int expected = 1;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcWorksCorrectWithLong1() {
        //When
        long result = calc.sum(1l);

        //Then
        long expected = 1;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcWorksCorrectWithInt5() {
        //When
        int result = calc.sum(5);

        //Then
        int expected = 15;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcWorksCorrectWithLong5() {
        //When
        long result = calc.sum(5l);

        //Then
        long expected = 15;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcWorksCorrectWithInt65000() {
        //When
        int result = calc.sum(65000);

        //Then
        int expected = 2112532500;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcWorksCorrectWithLong65000() {
        //When
        long result = calc.sum(65000l);

        //Then
        long expected = 2112532500;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcThrowExceptionWithInt0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.sum(0);
        });
    }

    @Test
    public void testThatCalcThrowExceptionWithLong0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.sum(0l);
        });
    }

    @Test
    public void testThatCalcWorksIncorrectWithInt100000() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //When
        int sumResult = calc.sum(100000);
        Boolean result = sumResult > 2147483647;  //max capacity of int type (sumResult should be 5000050000)

        //Then
        Boolean expected = true;
        String warning = "The result obtained with a high degree of probability is incorrect";  //66 chars

        Assertions.assertNotEquals(expected, result);
        Assertions.assertEquals(warning, outContent.toString().substring(0,66));

        System.setOut(originalOut);
    }

    @Test
    public void testThatCalcWorksCorrectWithLong100000() {
        //When
        long result = calc.sum(100000l);

        //Then
        long expected = 5000050000l;
        Assertions.assertEquals(expected, result);
    }
}
