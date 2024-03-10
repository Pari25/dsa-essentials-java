package Dp;

public class optimalGameStrategy {

    private static int optimalGameStrategy(int[] arr, int i, int j) {

        if(i > j) return 0;
        int selectLast = arr[j] + Math.min(optimalGameStrategy(arr, i, j - 2),
                optimalGameStrategy(arr, i + 1, j - 1));
        int selectFirst = arr[i] + Math.min(optimalGameStrategy(arr, i + 1, j - 1),
                optimalGameStrategy(arr, i + 2, j));
        return Math.max(selectFirst, selectLast);
    }

    private static int optimalGameStrategyDP(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {

                int selectLast = arr[j] + Math.min(
                        ((j - 2 < 0) || (i > j - 2)) ? 0 : dp[i][j - 2],
                        ((i + 1 >= n) || (j - 1 < 0) || (i + 1 > j - 1)) ? 0: dp[i + 1][j - 1]);
                int selectFirst = arr[i] + Math.min(
                        ((i + 1 >= n) || (j - 1 < 0) || (i + 1 > j - 1)) ? 0: dp[i + 1][j - 1],
                        ((i + 2 >= n) || (j < 0) || (i + 2 > j)) ? 0: dp[i + 2][j]);
                dp[i][j] = Math.max(selectFirst, selectLast);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] arg) {

        int[] arr = {20, 30, 2, 2, 2, 10};
        System.out.println(optimalGameStrategy(arr, 0, arr.length - 1));
        System.out.println(optimalGameStrategyDP(arr));
    }
}
