package calculation;

public class Calculator {
    public int add(String numbersAsString) {
        if ("".equals(numbersAsString)) return 0;
        return Integer.valueOf(numbersAsString);
    }
}
