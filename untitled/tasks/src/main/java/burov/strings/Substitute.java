package burov.strings;

/**
 * Created by alexey on 18.09.2014.
 */
public class Substitute implements ISubstitute {
    public String replace(String toReplace, char toSearch, char toSubstitute) {
        char[] chars = toReplace.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
                    if (chars[i] == toSearch) {
                        chars[i] = toSubstitute;
                    }
                }
        return new String(chars);
    }
}
