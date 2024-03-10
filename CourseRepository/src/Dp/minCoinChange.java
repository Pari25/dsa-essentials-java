package Dp;

public class minCoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{ 1, 3, 7, 10};
        int sum = 15;

        int[] dp = new int[sum + 1];

        System.out.println(minCoin(coins, sum, dp));

        int res = minCoinTopDown(coins, sum, dp);
        System.out.println((res == Integer.MAX_VALUE) ? -1 : res);
    }

    //Top Down Approach
    private static int minCoinTopDown(int[] coins, int sum, int[] dp) {
        if(sum == 0) return 0;
        if(sum < 0) return Integer.MAX_VALUE;

        if(dp[sum] != 0) return dp[sum];

        dp[sum] = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            dp[sum] = Math.min(dp[sum], minCoinTopDown(coins, sum - coins[i], dp));
        }
        if(dp[sum] != Integer.MAX_VALUE) {
            dp[sum]++;
        }

        return dp[sum];
    }


    //Bottom up approach
    private static int minCoin(int[] coins, int sum, int[] dp) {

        for(int i = 1; i <= sum; i++) {

           int res = Integer.MAX_VALUE;
           for(int j = 0; j < coins.length; j++) {
               if((i - coins[j]) >= 0) {
                   res = Math.min(res, dp[i - coins[j]]);
               }
           }
           dp[i] = (res == Integer.MAX_VALUE) ? res : res + 1;
        }

        return (dp[sum] == Integer.MAX_VALUE) ? -1 : dp[sum];


    }
}
