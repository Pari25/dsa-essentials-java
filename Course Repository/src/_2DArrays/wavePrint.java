package _2DArrays;

public class wavePrint {

    private static void print(int[][] arr, int n, int m) {

        int j = m - 1;
        while( j >= 0) {

            for(int i = 0; i < n; i++) {
                System.out.print(arr[i][j] + " ");
            }
            j--;
            if(j < 0) {
                break;
            }
            for(int i = n - 1; i >= 0; i--) {
                System.out.print(arr[i][j] + " ");
            }
            j--;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        //Print in spiral form
        int arr[][] = {{1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};

        int n = 4, m = 4;

        print(arr, n, m);

        int[][] arr2 = {{1}, {2}, {3}, {4}};
        n = 4;  m = 1;

        print(arr2, n, m);

    }
}
