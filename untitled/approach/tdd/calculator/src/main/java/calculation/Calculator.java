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
        return SplitterFactory.getSplitter(delimiterAndNumbers).split();
    }

}
