package calculation;

public class SplitterFactory {

    static Splitter getSplitter(String delimiterAndNumbers) {
        if (delimiterAndNumbers.contains("//")) {
            if (delimiterAndNumbers.contains("[") && delimiterAndNumbers.contains("]")) {
                return new BracketsDelimiterSplitter(delimiterAndNumbers);
            }
            return new CustomDelimiterSplitter(delimiterAndNumbers);
        }
        return new DefaultSplitter(delimiterAndNumbers);
    }
}
