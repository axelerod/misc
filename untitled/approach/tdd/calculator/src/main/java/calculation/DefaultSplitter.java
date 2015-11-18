package calculation;

class DefaultSplitter extends Splitter {
    public DefaultSplitter(String delimiterAndNumbers) {
        super(delimiterAndNumbers);
    }

    public String[] split() {
        String effectiveDelimiters = DEFAULT_DELIMITERS;
        String delimitedNumbers = delimiterAndNumbers;
        return delimitedNumbers.split(effectiveDelimiters);
    }
}
