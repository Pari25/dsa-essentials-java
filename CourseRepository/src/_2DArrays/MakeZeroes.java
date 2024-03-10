package _2DArrays;

/**
Given a Matrix arr of size M x N, the task is to set all rows and columns to zeroes
 if a particular element is zero, in constant space complexity.
**/
public class MakeZeroes {


    /**
     * arr[0][0] represents if row 0 has to be made 0. col0 flag represents if col[0] has to be made 0.
    **/
    private static void makeZeroes(int[][] arr, int m, int n) {

        boolean col0 = false;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if(j == 0) {
                        col0 = true;
                    } else {
                        arr[0][j] = 0;
                    }
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
        if(arr[0][0] == 0) {
            for(int j = 0; j < n; j++) {
                arr[0][j] = 0;
            }
        }
        if(col0) {
            for(int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }
    }

    private static void print(int[][] arr, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        //Print in spiral form
        int arr[][] = {
                {5, 4, 3, 9},
                {2, 0, 7, 6},
                {1, 3, 4, 0},
                {9, 8, 3, 4}};

        int n = 4, m = 4;
        makeZeroes(arr, m, n);
        print(arr, n, m);
    }

}
