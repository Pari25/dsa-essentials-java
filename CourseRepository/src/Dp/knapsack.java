package Dp;

public class knapsack {

    private static int knapsack(int[] wt, int[] price, int W, int N) {

        int[][] dp = new int[N + 1][W + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j - wt[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], price[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }

        return dp[N][W];
    }


    //Space reduced from O(NW) to O(W)
    private static int knapsackOptimised(int[] wt, int[] price, int W, int N) {

        int[] prev = new int[W + 1];
        int[] cur;

        for(int i = 1; i <= N; i++) {
            cur = new int[W + 1];
            for(int j = 1; j <= W; j++) {
                cur[j] = prev[j];
                if(j - wt[i - 1] >= 0) {
                    cur[j] = Math.max(cur[j], price[i - 1] + prev[j - wt[i - 1]]);
                }
            }

            prev = cur;
        }

        return prev[W];
    }

    public static void main(String[] args) {

        int[] wt = new int[] {2, 7, 3, 4};
        int[] prices = new int[] {5, 20, 20, 10};

        int W = 11, N = 4;
        System.out.println(knapsack(wt, prices, W, N));
        System.out.println(knapsackOptimised(wt, prices, W, N));
    }
}
