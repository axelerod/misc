package calculation;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

public class Calculator {

    public int add(String delimiterAndNumbers) {
        if (delimiterAndNumbers == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (delimiterAndNumbers.isEmpty()) return 0;

        String[] splitted = split(delimiterAndNumbers);

        int[] negativeNumbers = StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).filter(a -> a < 0).toArray();

        if (negativeNumbers.length > 0) {
            throw new IllegalArgumentException("Negatives are not allowed: " + negativeNumbers);
        }

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }

    private String[] split(String delimiterAndNumbers) {
        return SplitterFactory.getSplitter(delimiterAndNumbers).split();
    }
}
