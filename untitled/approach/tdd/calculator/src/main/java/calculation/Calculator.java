package calculation;

import java.util.Arrays;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class Calculator {
    public int add(String numbersAsString) {
        if (numbersAsString == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (numbersAsString.isEmpty()) return 0;

        String[] splitted = numbersAsString.split(",");

        if (splitted.length == 1) {
            return toInt(numbersAsString);
        }

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }


    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
