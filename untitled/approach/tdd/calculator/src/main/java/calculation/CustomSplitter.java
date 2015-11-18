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
            Pattern pattern = Pattern.compile("(\\[.+?\\])+?");
            Matcher matcher = pattern.matcher(customDelimiter);
            matcher.find();
            String group = matcher.group();
            customDelimiter = group.substring(1, group.length() -1);
            while (matcher.find()) {
                String group1 = matcher.group();
                customDelimiter = customDelimiter + "|" +group1.substring(1, group1.length() -1);
            }
        }

        String effectiveDelimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
        String delimitedNumbers = delimiterAndNumbers.substring(newLineIndex + 1);

        return delimitedNumbers.split(effectiveDelimiters);
    }

    private boolean delimiterInBrackets(String customDelimiter) {
        return customDelimiter.startsWith("[") && customDelimiter.endsWith("]");
    }
}
