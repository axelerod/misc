package calculation;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void shouldReturnNumbersInCaseOneNumberPassed() {

        assertEquals(45, calculator.add("45"));
    }

    @Test
    public void shouldAcceptEmptyValue() {
        assertEquals(0, calculator.add(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionInCaseNullIsPassed() {
        calculator.add(null);
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        assertEquals(7, calculator.add("3,4"));
    }
}
