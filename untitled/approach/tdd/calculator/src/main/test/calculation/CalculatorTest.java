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
    public void shouldReturnSumOfAnyNumberOfNumcbers() {
        assertEquals(2 + 3 + 4 + 5 + 6 + 7 + 8, calculator.add("2,3,4,5,6,7,8"));
    }

    @Test
    public void shouldAcceptBothNewLineAndCommaCharacters() {
        assertEquals(2 + 3 + 4, calculator.add("2\n3,4"));
    }

    @Test
    public void shouldBeAbleToPassCustomDelimiter() {
        assertEquals(2 + 3 + 4, calculator.add("//;\n2;3;4"));
    }

    @Test
    public void shouldSupportDefaultAndCustomDelimiters() {
        assertEquals(2 + 3 + 4 + 5, calculator.add("//;\n2;3\n4,5"));
    }

    @Test
    public void shouldSupportMultiSymbolDelimiters() {
        assertEquals(2 + 3 + 4, calculator.add("//-d\n2-d3-d4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionInCaseNegativeNumberIsPassed() {
        calculator.add("3,-1");
    }

    @Test
    public void numbersGreatedThen1000ShouldBeIgnored() {
        assertEquals(2 + 3 + 4, calculator.add("2,3,1001,4"));
    }

    @Test
    public void shouldSupportDelimitersPassedInSquareBrackets() {
        assertEquals(2 + 3+ 4, calculator.add("//[---]\n2---3---4"));
    }

    @Test
    public void shouldSupportMultipleDelimitersInBrackets() {
        assertEquals(2 + 3 + 4, calculator.add("//[-][d]\n2-3d4"));
    }
}
