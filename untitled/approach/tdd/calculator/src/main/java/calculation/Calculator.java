package calculation;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Calculator {

    public static final String DEFAULT_DELIMITERS = ",|\\v";

    public int add(String delimiterAndNumbers) {
        if (delimiterAndNumbers == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (delimiterAndNumbers.isEmpty()) return 0;

        String[] splitted = split(delimiterAndNumbers);

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }

    private String[] split(String delimiterAndNumbers) {
        return getSplitter(delimiterAndNumbers).split();
    }

    private Splitter getSplitter(String delimiterAndNumbers) {
        return new Splitter(delimiterAndNumbers);
    }

    private class Splitter {
        private String delimiterAndNumbers;

        public Splitter(String delimiterAndNumbers) {
            this.delimiterAndNumbers = delimiterAndNumbers;
        }

        public String[] split() {
            String effectiveDelimiters;
            String delimitedNumbers;

            if (delimiterAndNumbers.contains("//")) {
                String customDelimiter = delimiterAndNumbers.substring(2,3);
                effectiveDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
                delimitedNumbers = delimiterAndNumbers.substring(4);
                return delimitedNumbers.split(effectiveDelimiters);
            } else {
                effectiveDelimiters = DEFAULT_DELIMITERS;
                delimitedNumbers = delimiterAndNumbers;
                return delimitedNumbers.split(effectiveDelimiters);
            }

        }
    }
}
