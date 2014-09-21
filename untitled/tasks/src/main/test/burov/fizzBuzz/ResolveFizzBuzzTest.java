package burov.fizzBuzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResolveFizzBuzzTest {
    @Test
    public void testFizzBuzz() {
        ResolveFizzBuzz resolveFizzBuzz = new ResolveFizzBuzz();
        assertArrayEquals(new String[]{"1", "2", "Fizz", "4", "Buzz"}, resolveFizzBuzz.fizzBuzz(1,6));
        assertArrayEquals(new String[]{"11", "Fizz", "13", "14", "FizzBuzz", "16"}, resolveFizzBuzz.fizzBuzz(11,17));
    }
}