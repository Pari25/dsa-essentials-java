package BackTracking;

public class findWordInMatrix {

    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};

    static boolean[][] visited = new boolean[3][4];

    private static boolean findWordInMatrixHelper(char[][] board, String word, int i, int j, int k) {

        if(k == word.length()) {
            return true;
        }

        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j]) {
            return false;
        }

        if(board[i][j] != word.charAt(k)) return false;
        visited[i][j] = true;
        for(int count = 0; count < 4; count++) {
            int newi = i + x[count];
            int newj = j + y[count];
            if(findWordInMatrixHelper(board, word, newi, newj, k + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }

    private static boolean findWordInMatrix(char[][] board, String word) {

        for(int m = 0; m < board.length; m++) {
            for(int n = 0; n < board[0].length; n++) {
                if(board[m][n] == word.charAt(0) && findWordInMatrixHelper(board, word, m, n, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        if(findWordInMatrix(board, word)) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
    }
}
