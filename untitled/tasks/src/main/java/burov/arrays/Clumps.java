package burov.arrays;

/**
 * Created by alexey on 19.09.2014.
 */
public class Clumps implements IClumps{

    public int countClumps(int[] nums) {
        int totalClubms = 0;
        int counter = 1;
        int lastNumber = nums[0];

        for (int i = 1; i <= nums.length-1; i++) {
            if (nums[i] == lastNumber) {
                if (counter == 1) {
                    totalClubms++;
                }
                counter++;
            } else {
                counter = 1;
                lastNumber = nums[i];
            }
        }
        return totalClubms;
    }
}
