package Dp;

public class vacationMaxPoints {



    private static int vacationMaxPoints(int[] a, int[] b, int[] c, int i, int prev) {

        if(i == a.length) return 0;

        int ansA = (prev == 0) ? 0 : (a[i] + vacationMaxPoints(a, b, c, i + 1, 0));
        int ansB = (prev == 1) ? 0 : (b[i] + vacationMaxPoints(a, b, c, i + 1, 1));
        int ansC = (prev == 2) ? 0 : (c[i] + vacationMaxPoints(a, b, c, i + 1, 2));

        int max = Math.max(ansA, ansB);
        max = Math.max(max, ansC);

        return max;
    }

    private static int vacationMaxPointsByDP(int[] a, int[] b, int[] c, int n) {

        int[][] dp = new int[3][n + 1];

        for(int j = n - 1; j >= 0; j--) {
            dp[0][j] = a[j] + Math.max(dp[1][j + 1], dp[2][j + 1]);
            dp[1][j] = b[j] + Math.max(dp[0][j + 1], dp[2][j + 1]);
            dp[2][j] = c[j] + Math.max(dp[0][j + 1], dp[1][j + 1]);
        }

        int max = Math.max(dp[0][0], dp[1][0]);
        max = Math.max(max, dp[2][0]);

        return max;
    }

    public static void main(String[] args) {

        int[] a = {10, 20, 30};
        int[] b = {40, 50, 60};
        int[] c = {70, 80, 90};


        System.out.println(vacationMaxPoints(a, b, c, 0, -1));
        System.out.println(vacationMaxPointsByDP(a, b, c, a.length));
    }
}
