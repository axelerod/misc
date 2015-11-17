package calculation;

public class Calculator {
    public int add(String numbersAsString) {
        if (numbersAsString == null)
            throw new IllegalArgumentException("Null not acceptable!");

        if (numbersAsString.isEmpty()) return 0;

        String[] splitted = numbersAsString.split(",");

        if (splitted.length == 1) {
            return Integer.valueOf(numbersAsString);
        }
        if (splitted.length == 2) {
            return Integer.parseInt(splitted[0]) + Integer.parseInt(splitted[1]);
        }

        return Integer.parseInt(splitted[0]) + Integer.parseInt(splitted[1]) + Integer.parseInt(splitted[2]);
    }
}
