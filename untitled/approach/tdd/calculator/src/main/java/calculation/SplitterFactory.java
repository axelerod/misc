package calculation;

public class SplitterFactory {

    static Splitter getSplitter(String delimiterAndNumbers) {
        if (delimiterAndNumbers.contains("//")) {
            return new CustomSplitter(delimiterAndNumbers);
        }
        return new DefaultSplitter(delimiterAndNumbers);
    }
}
