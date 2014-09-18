package burov.strings;

/**
 * Created by alexey on 18.09.2014.
 */
public class Chars implements ISubstitute {
    public String replace(String toReplace, char toSearch, char toSubstitute) {
        char[] chars = toReplace.toCharArray();
        return new String(replace(chars, toSearch, toSubstitute));
    }

    private char[] replace(char[] chars, char toSearch, char toReplace) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == toSearch) {
                chars[i] = toReplace;
            }
        }
        return chars;
    }
}
