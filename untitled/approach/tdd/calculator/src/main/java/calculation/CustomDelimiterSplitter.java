package calculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomDelimiterSplitter extends Splitter {
    public CustomDelimiterSplitter(String delimiterAndNumbers) {
        super(delimiterAndNumbers);
    }

    @Override
    public String[] split() {
        int newLineIndex = delimiterAndNumbers.indexOf("\n");
        String delimitersContent = delimiterAndNumbers.substring(2, newLineIndex);
        String effectiveDelimiters = DEFAULT_DELIMITERS + "|" + delimitersContent;
        String delimitedNumbers = delimiterAndNumbers.substring(newLineIndex + 1);

        return delimitedNumbers.split(effectiveDelimiters);
    }
}
