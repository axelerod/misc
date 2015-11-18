package calculation;

abstract class Splitter {
    static final String DEFAULT_DELIMITERS = ",|\\v";

    protected String delimiterAndNumbers;

    public Splitter(String delimiterAndNumbers) {
        this.delimiterAndNumbers = delimiterAndNumbers;
    }

    public abstract String[] split();
}
