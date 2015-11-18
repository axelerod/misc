package calculation;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Calculator {
    public int add(String delimiterAndNumbers) {
        if (delimiterAndNumbers == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (delimiterAndNumbers.isEmpty()) return 0;

        String defaultDelimiters = ",|\\v";
        String effectiveDelimiters = defaultDelimiters;
        String oneCharDelimiter = "";
        String delimitedNumbers = delimiterAndNumbers;
        if (delimiterAndNumbers.contains("//")) {
            oneCharDelimiter = delimiterAndNumbers.substring(2,3);
            effectiveDelimiters = defaultDelimiters + "|" + oneCharDelimiter;
            delimitedNumbers = delimiterAndNumbers.substring(4);
        }

        String[] splitted = delimitedNumbers.split(effectiveDelimiters);

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
