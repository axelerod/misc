package calculation;

class CustomSplitter extends Splitter {
    public CustomSplitter(String delimiterAndNumbers) {
        super(delimiterAndNumbers);
    }

    @Override
    public String[] split() {
        int newLineIndex = delimiterAndNumbers.indexOf("\n");
        String customDelimiter = delimiterAndNumbers.substring(2, newLineIndex);

        if (delimiterInBrackets(customDelimiter)) {
            customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
        }

        String effectiveDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
        String delimitedNumbers = delimiterAndNumbers.substring(newLineIndex + 1);

        return delimitedNumbers.split(effectiveDelimiters);
    }

    private boolean delimiterInBrackets(String customDelimiter) {
        return customDelimiter.startsWith("[") && customDelimiter.endsWith("]");
    }
}
