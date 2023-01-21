import org.example.SumCalculator;
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
    public void testThatCalcWorksCorrectWith65000() {
        //When
        int result = calc.sum(65000);

        //Then
        int expected = 2112532500;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testThatCalcThrowExceptionWith0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.sum(0);
        });
    }

    @Test
    public void testThatCalcThrowExceptionWith100000() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.sum(100000);
        });
    }
}
