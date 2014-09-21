package burov.fizzBuzz;

/**
 * Created by KA on 21.09.2014.
 */
public class ResolveFizzBuzz {

    public String[] fizzBuzz(int start, int end) {
        final int FIZ_INT = 3;
        final int BUZ_INT = 5;
        final int FIZ_BUZ_INT = FIZ_INT * BUZ_INT;
        final String FIZ = "Fizz";
        final String BUZ = "Buzz";
        final String FIZ_BUZ = FIZ + BUZ;

        String[] result = new String[end - start];
        for (int i = start; i < end; i++) {
            String s;
            if (i % FIZ_BUZ_INT == 0) {
                s = FIZ_BUZ;
            } else if (i % FIZ_INT == 0) {
                s = FIZ;
            } else if (i % BUZ_INT == 0) {
                s = BUZ;
            } else s = String.valueOf(i);
            result[i - start] = s;
        }

        return result;
    }
}
