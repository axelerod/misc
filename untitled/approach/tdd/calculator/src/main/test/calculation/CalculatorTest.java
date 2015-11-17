package calculation;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void shouldAddNumber() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void shouldReturnNumbersInCaseOneNumberPassed() {
        Calculator calculator = new Calculator();

        assertEquals(45, calculator.add("45"));
    }

}
