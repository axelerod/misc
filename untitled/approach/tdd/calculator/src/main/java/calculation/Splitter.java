package calculation;

class Splitter {
    private String delimiterAndNumbers;

    public Splitter(String delimiterAndNumbers) {
        this.delimiterAndNumbers = delimiterAndNumbers;
    }

    public String[] split() {
        String effectiveDelimiters;
        String delimitedNumbers;

        if (delimiterAndNumbers.contains("//")) {
            String customDelimiter = delimiterAndNumbers.substring(2,3);
            effectiveDelimiters = Calculator.DEFAULT_DELIMITERS + "|" + customDelimiter;
            delimitedNumbers = delimiterAndNumbers.substring(4);
            return delimitedNumbers.split(effectiveDelimiters);
        } else {
            effectiveDelimiters = Calculator.DEFAULT_DELIMITERS;
            delimitedNumbers = delimiterAndNumbers;
            return delimitedNumbers.split(effectiveDelimiters);
        }

    }
}
