package calculation;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldReturnNumbersInCaseOneNumberPassed() {

        assertEquals(45, new Calculator().add("45"));
    }

    @Test
    public void shouldAcceptEmptyValue() {
        assertEquals(0, new Calculator().add(""));
    }
}
