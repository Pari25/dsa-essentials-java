package _2DArrays;

/** Rotate a N * N square matrix in place by 90 degree clockwise.
 * **/
public class rotateMatrix {

    private static void rotateMatrixInPlace(int[][] arr, int n, int m) {
        rotateColumn(arr, n, m);
        takeTranspose(arr, n, m);
        print(arr, n, m);
    }

    private static void print(int[][] arr, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void takeTranspose(int[][] arr, int n, int m) {
        for(int i = 0; i < n; i++) {
            //It has to be from i, else if you keep j = 0, then same elements will get swapped again.
            for(int j = i; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    private static void rotateColumn(int[][] arr, int n, int m) {

        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n / 2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - i][j];
                arr[n - 1 - i][j] = temp;
            }
        }
    }

    public static void main (String[] args) {

        //Print in spiral form
        int arr[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int n = 3, m = 3;

        rotateMatrixInPlace(arr, n, m);
    }
}
