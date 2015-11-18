package calculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomSplitter extends Splitter {
    public CustomSplitter(String delimiterAndNumbers) {
        super(delimiterAndNumbers);
    }

    @Override
    public String[] split() {
        int newLineIndex = delimiterAndNumbers.indexOf("\n");
        String customDelimiter = delimiterAndNumbers.substring(2, newLineIndex);

        if (delimiterInBrackets(customDelimiter)) {
            customDelimiter = buildCustomDelimiters(customDelimiter);
        }

        String effectiveDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
        String delimitedNumbers = delimiterAndNumbers.substring(newLineIndex + 1);

        return delimitedNumbers.split(effectiveDelimiters);
    }

    private String buildCustomDelimiters(String customDelimiter) {
        Pattern pattern = Pattern.compile("(\\[.+?\\])+?");
        Matcher matcher = pattern.matcher(customDelimiter);
        StringBuilder delimitersCollector = new StringBuilder("");

        matcher.find();
        String firstMatchedGroup = matcher.group();
        delimitersCollector.append(firstMatchedGroup.substring(1, firstMatchedGroup.length() - 1));

        while (matcher.find()) {
            String anotherMatchedGroup = matcher.group();
            delimitersCollector.append("|").append(anotherMatchedGroup.substring(1, anotherMatchedGroup.length() - 1));
        }
        return delimitersCollector.toString();
    }

    private boolean delimiterInBrackets(String customDelimiter) {
        return customDelimiter.startsWith("[") && customDelimiter.endsWith("]");
    }
}
