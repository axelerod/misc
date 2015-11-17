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

    @Test
    public void shouldReturnSumOfThreeNumbers() {
        assertEquals(12, calculator.add("3,4,5"));
    }

    @Test
    public void shouldReturnSumOfAnyNumberOfNumcbers() {
        assertEquals(35, calculator.add("2,3,4,5,6,7,8"));
    }
}
