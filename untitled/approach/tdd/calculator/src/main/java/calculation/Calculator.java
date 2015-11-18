package calculation;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Calculator {

    public int add(String delimiterAndNumbers) {
        validateNotNull(delimiterAndNumbers);

        if (checkIfEmpty(delimiterAndNumbers)) return 0;

        String[] splitted = split(delimiterAndNumbers);

        validateNegativeNumbers(splitted);

        return StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a += b);
    }

    private boolean checkIfEmpty(String delimiterAndNumbers) {
        return delimiterAndNumbers.isEmpty();
    }

    private void validateNegativeNumbers(String[] splitted) {
        int[] negativeNumbers = StreamSupport.stream(Arrays.spliterator(splitted), false).mapToInt(Integer::parseInt).filter(a -> a < 0).toArray();

        if (negativeNumbers.length > 0) {
            throw new IllegalArgumentException("Negatives are not allowed: " + negativeNumbers);
        }
    }

    private void validateNotNull(String delimiterAndNumbers) {
        if (delimiterAndNumbers == null)
            throw new IllegalArgumentException("Null not acceptable!");
    }

    private String[] split(String delimiterAndNumbers) {
        return SplitterFactory.getSplitter(delimiterAndNumbers).split();
    }
}
