package Dp;

/**
 * Given n wines in a row, with integers denoting the cost of each wine respectively.
 * Each year you can sell the first or the last wine in a row.
 * However, the price of wines increases over time. Let the initial profits from the wines be P1, P2, P3…Pn.
 * In the Yth year, the profit from the ith wine will be Y*Pi.
 * Calculate the maximum profit from all the wines.
 */
public class maxWineSaleProfit {

    public static void main(String[] args) {

        int[] price = { 2, 4, 6, 2, 5 };

        int n = price.length;

        int[][] dp = new int[n][n];

        System.out.println(maxProfit(price, 0, n - 1, 1, dp));
        System.out.println(maxProfitBottomUp(price, n));
    }

    //Top down approach
    //Here year is linearly increasing and can also be derived from start and end. So, we don't need a 3D dp array.
    private static int maxProfit(int[] price, int start, int end, int year, int[][] dp) {

        if(start > end) return 0;

        if(dp[start][end] != 0) return dp[start][end];

        int leftProfit = (price[start] * year) + maxProfit(price, start + 1, end, year + 1, dp);
        int rightProfit = (price[end] * year) + maxProfit(price, start, end - 1, year + 1, dp);

        dp[start][end] = Math.max(leftProfit, rightProfit);

        return dp[start][end];
    }

    private static int maxProfitBottomUp(int[] price, int n) {

        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++) {
            for(int i = j; i >= 0; i--) {

                int year = n - (j - i);
                if(i == j) {
                    dp[i][j] = price[i] * year;
                } else {
                    int lCost = (price[i] * year) + dp[i + 1][j];
                    int rCost = price[j] * year + dp[i][j - 1];
                    dp[i][j] = Math.max(lCost, rCost);
                }

            }
        }

        return dp[0][n - 1];
    }

}
