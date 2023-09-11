package basicSorting;

import java.util.Arrays;

public class chopstickPairs {

    private static int getMaxPairsWithAtMostAllowedDiff(int[] chopstickLength, int maxDiffAllowed) {

        Arrays.sort(chopstickLength);
        int i = 0, maxPairs = 0;
        while(i < chopstickLength.length - 1) {
            if(chopstickLength[i + 1] - chopstickLength[i] <= maxDiffAllowed) {
                maxPairs++;
                i += 2;
            } else {
                i++;
            }
        }

        return maxPairs;
    }

    public static void main(String[] args) {

        int[] chopstickLength = {1, 3, 3, 9, 4, 5};
        int maxDiffAllowed = 4;

        System.out.println(getMaxPairsWithAtMostAllowedDiff(chopstickLength, maxDiffAllowed));
    }

}
