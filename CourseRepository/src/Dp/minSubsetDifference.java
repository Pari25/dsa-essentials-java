package Dp;

/**
 * Minimum Partitioning
 *
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements,
 * Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 */
public class minSubsetDifference {

    private static int minimumPartitioningDP(int[] arr, int totalSum) {

        int[][] dp = new int[arr.length + 1][totalSum + 1];
        dp[arr.length][0] = 1;

        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = 0; j <= totalSum; j++) {
                if(dp[i + 1][j] == 1) {
                    dp[i][j + arr[i]] = 1;
                    dp[i][j] = 1;
                }
            }
        }

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;

        for(int j = (totalSum / 2) ; j >= 0; j--) {
            if(dp[0][j] == 1) {
                m1 = Math.abs(totalSum - (2 * j));
                break;
            }
        }

        for(int j = (totalSum / 2) ; j <= totalSum; j++) {
            if(dp[0][j] == 1) {
                m2 = Math.abs(totalSum - (2 * j));
                break;
            }
        }

        return Math.min(m1, m2);

    }



    private static int minimumPartitioning(int[] arr, int i, int subArraySum, int totalSum) {

        if(i == arr.length) {
            return Math.abs(subArraySum - (totalSum - subArraySum));
        }

        return Math.min(minimumPartitioning(arr, i + 1, subArraySum + arr[i], totalSum),
                minimumPartitioning(arr, i + 1, subArraySum, totalSum));
    }

    public static void main(String[] args) {

        int[] arr = {1, 6, 11, 5, 3};
        int totalSum = 0;
        for(int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        System.out.println(minimumPartitioning(arr, 0, 0, totalSum));
        System.out.println(minimumPartitioningDP(arr, totalSum));
    }


}
