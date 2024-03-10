package Dp;

public class coinChangeCombination {

    public static void main(String[] args) {

        int[] coins = new int[]{ 1, 2, 3};
        int sum = 4;
        System.out.println(findCombinations(sum, coins));
    }

    private static int findCombinations(int sum, int[] coins) {

        int[] prev = new int[sum + 1];
        int[] cur = new int[sum + 1];

        prev[0] = 1;

        for(int i = coins.length - 1; i >= 0; i--) {
            for(int j = 0; j <= sum; j++) {
                if(j == 0) cur[j] = 1;
                else {
                    cur[j] = prev[j];
                    if(coins[i] <= j) {
                        cur[j] += cur[j - coins[i]];
                    }
                }
            }
            prev = cur;
            cur = new int[sum + 1];
        }

        return prev[sum];
    }


}
