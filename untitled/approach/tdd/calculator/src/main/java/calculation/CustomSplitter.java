package calculation;

class CustomSplitter extends Splitter {
    public CustomSplitter(String delimiterAndNumbers) {
        super(delimiterAndNumbers);
    }

    @Override
    public String[] split() {
        String customDelimiter = delimiterAndNumbers.substring(2,3);
        String effectiveDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
        String delimitedNumbers = delimiterAndNumbers.substring(4);
        return delimitedNumbers.split(effectiveDelimiters);
    }
}
