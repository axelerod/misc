package calculation;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Calculator {

    public static final String DEFAULT_DELIMITERS = ",|\\v";

    public int add(String delimiterAndNumbers) {
        if (delimiterAndNumbers == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (delimiterAndNumbers.isEmpty()) return 0;

        String effectiveDelimiters = DEFAULT_DELIMITERS;
        String delimitedNumbers = delimiterAndNumbers;

        if (delimiterAndNumbers.contains("//")) {
            String customDelimiter = delimiterAndNumbers.substring(2,3);
            effectiveDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            delimitedNumbers = delimiterAndNumbers.substring(4);
        }

        String[] splitted = delimitedNumbers.split(effectiveDelimiters);

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }
}
