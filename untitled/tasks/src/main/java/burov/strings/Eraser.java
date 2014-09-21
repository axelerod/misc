package burov.strings;

/**
 * Created by KA on 21.09.2014.
 */
public class Eraser {
    public String withoutString(String base, String remove) {
        int snippetLength = remove.length();
        int pointer = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            String symbol = base.substring(i, i + 1);
            String templateSymbol = remove.substring(pointer, pointer + 1);
            if (symbol.toLowerCase().equals(templateSymbol.toLowerCase())) {
                sub.append(symbol);
                pointer++;
                // if sub string matches template, reset search
                if (pointer == snippetLength) {
//                    result.append(sub);
                    // reset buffer
                    sub = new StringBuilder();
                    pointer = 0;
                }
            } else {
                // append both sub string and current symbol;
                result.append(sub).append(symbol);
                // reset sub string search buffer and pointer;
                sub = new StringBuilder();
                pointer = 0;
            }
        }

        return result.toString();
    }
}
