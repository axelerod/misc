package calculation;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Calculator {
    public int add(String numbersAsString) {
        if (numbersAsString == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (numbersAsString.isEmpty()) return 0;

        String delimiter = ",|\\v";
        if (numbersAsString.contains("//")) {
            delimiter = numbersAsString.substring(2,3);
            numbersAsString = numbersAsString.substring(4);
        }

        String[] splitted = numbersAsString.split(delimiter);

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
