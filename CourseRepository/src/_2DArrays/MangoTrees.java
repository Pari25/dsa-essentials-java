package _2DArrays;


/**
 *  Ramu's father has left a farm organized as an N × N grid.
 *  Each square in the grid either has or does not have a mango tree.
 *  He has to divide the farm with his three sisters as follows:
 *  he will draw one horizontal line and one vertical line to divide the field into four rectangles.
 *  His sisters will choose three of the four smaller fields and he gets the last one.
 * He wants to divide the field so that he gets the maximum number of mangos possible,
 * assuming that his sisters will pick the best three rectangles.
 *  For example, suppose the field looks as follows:
 *
 *       . # # . . .
 *       # . . # # .
 *       . # . . . .
 *       . # # . . #
 *       # . . # # .
 *       . # . . . .
 *
 *
 * Ramu can ensure that he gets at least 3 mango trees by cutting as follows:
 *
 *         . # | # . . .
 *         # . | . # # .
 *         . # | . . . .
 *       ------+---------
 *         . # | # . . #
 *         # . | . # # .
 *         . # | . . . .
 *
 */
public class MangoTrees {

    private static int findMaxMangoes(int[][] arr, int n, int m) {

        int[][] prefixSum = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                prefixSum[i][j] = ((i == 0) ? 0 : prefixSum[i - 1][j])
                        + ((j == 0) ? 0 : prefixSum[i][j - 1])
                        - ((i > 0 && j > 0) ? prefixSum[i - 1][j - 1] : 0)
                        + arr[i][j];
            }
        }

        int maxMangoes = 0;
        int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum1 = prefixSum[i][j];
                sum2 = prefixSum[i][m - 1] - prefixSum[i][j];
                sum3 = prefixSum[n - 1][j] - prefixSum[i][j];
                sum4 = prefixSum[n - 1][m - 1] - (sum1 + sum2 + sum3);

                int min = Math.min(sum1, sum2);
                min = Math.min(min, sum3);
                min = Math.min(min, sum4);
                maxMangoes = Math.max(maxMangoes, min);
            }
        }

        return maxMangoes;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0}
        };

        int n = 6, m = 6;

        System.out.println(findMaxMangoes(arr, n, m));

    }
}
