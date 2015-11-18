package calculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketsDelimiterSplitter extends Splitter {

    public BracketsDelimiterSplitter(String delimiterAndNumbers) {
        super(delimiterAndNumbers);
    }

    @Override
    public String[] split() {
        int newLineIndex = delimiterAndNumbers.indexOf("\n");
        String delimitersContent = delimiterAndNumbers.substring(2, newLineIndex);

        delimitersContent = buildCustomDelimiters(delimitersContent);

        String effectiveDelimiters = DEFAULT_DELIMITERS + delimitersContent;
        String delimitedNumbers = delimiterAndNumbers.substring(newLineIndex + 1);

        return delimitedNumbers.split(effectiveDelimiters);
    }

    private String buildCustomDelimiters(String customDelimiter) {
        Pattern pattern = Pattern.compile("(\\[.+?\\])+?");
        Matcher matcher = pattern.matcher(customDelimiter);
        StringBuilder delimitersCollector = new StringBuilder("");

        while (matcher.find()) {
            String anotherMatchedGroup = matcher.group();
            delimitersCollector.append("|").append(anotherMatchedGroup.substring(1, anotherMatchedGroup.length() - 1));
        }
        return delimitersCollector.toString();
    }
}

