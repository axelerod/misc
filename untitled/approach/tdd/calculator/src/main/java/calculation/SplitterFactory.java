package calculation;

public class SplitterFactory {
    static Splitter getSplitter(String delimiterAndNumbers) {
        return new Splitter(delimiterAndNumbers);
    }
}
