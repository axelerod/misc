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
            return toInt(splitted[0]) + toInt(splitted[1]);
        }

        return toInt(splitted[0]) + toInt(splitted[1]) + toInt(splitted[2]);
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
