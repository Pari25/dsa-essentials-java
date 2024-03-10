package Dp;

public class longestIncreasingSubsequence {

    private static int lis(int[] arr, int length) {
        //dp[i] stores the lis ending at index i
        int[] dp = new int[length];
        dp[0] = 1;
        int maxSoFar = 1;

        for(int i = 0; i < length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] <= arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxSoFar = Math.max(maxSoFar, dp[i]);
        }

        return maxSoFar;

    }


    public static void main(String[] args) {

        int[] arr = new int[] {50, 4, 10, 8, 30, 100};

        System.out.println(lis(arr, arr.length));
    }
}
