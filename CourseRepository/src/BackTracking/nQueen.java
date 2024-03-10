package BackTracking;

public class nQueen {

    private static void printBoard(int[][] arr) {

        System.out.println("New config");
        for(int i = 0; i < arr[0].length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    System.out.println(i + "," + j);
                }
            }
        }
    }

    private static boolean nQueen(int[][] arr, int col, int n, int[] rowVisited) {

        if(col == arr.length) {
            printBoard(arr);
            return true;
        }

        for(int row = 0; row < arr[0].length; row++) {
            if(rowVisited[row] != 1 && isSafeDiagonal(arr, row, col)) {
                arr[row][col] = 1;
                rowVisited[row] = 1;

                if(nQueen(arr, col + 1, n - 1, rowVisited)) return true;
                arr[row][col] = 0;
                rowVisited[row] = 0;
            }

        }

        return false;
    }

    private static boolean isSafeDiagonal(int[][] arr, int row, int col) {
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == 1) return false;
        }

        for(int i = row + 1, j = col - 1; i < arr[0].length && j >= 0; i++, j--) {
            if(arr[i][j] == 1) return false;
        }

        return true;
    }


    // Variation to print all possible configurations and no of ways.
    private static int nQueenAllWays(int[][] arr, int col, int n, int[] rowVisited) {

        if(col == arr.length) {
            printBoard(arr);
            return 1;
        }

        int ways = 0;

        for(int row = 0; row < arr[0].length; row++) {
            if(rowVisited[row] != 1 && isSafeDiagonal(arr, row, col)) {
                arr[row][col] = 1;
                rowVisited[row] = 1;

                ways += nQueenAllWays(arr, col + 1, n - 1, rowVisited);
                arr[row][col] = 0;
                rowVisited[row] = 0;
            }

        }

        return ways;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] arr = new int[n][n];
        int[] rowVisited = new int[n];

        boolean isSolved = nQueen(arr, 0, n, rowVisited);

        if(!isSolved) {
            System.out.println("No solution found");
        }

        System.out.println("Printing all ways");

        arr = new int[n][n];
        rowVisited = new int[n];

        int totalWays = nQueenAllWays(arr, 0, n, rowVisited);

        if(totalWays == 0) {
            System.out.println("No solution found");
        } else {
            System.out.println("Total ways : " + totalWays);
        }
    }
}
