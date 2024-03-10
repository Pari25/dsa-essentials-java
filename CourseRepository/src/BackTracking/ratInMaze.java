package BackTracking;

public class ratInMaze {

    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};

    static boolean findPath(char[][] mat, int m, int n, int i, int j) {

        if(i == m - 1 && j == n - 1) {
            mat[i][j] = '1';
            return true;
        }

        if( i >= m || j >= n || i < 0 || j < 0 || mat[i][j] != '0') return false;

        mat[i][j] = '1';
        for(int childX = 0; childX < 4; childX++) {
            for(int childY = 0; childY < 4; childY++) {
                if(findPath(mat, m, n, i + x[childX], j + childY)) {
                    return true;
                }
            }
        }
        mat[i][j] = '0';
        return false;
    }

    public static void main(String[] args) {

        int m = 5, n = 4;
        char[][] mat =
                {{'0','X', '0', '0'},
                 {'0','0', '0', 'X'},
                 {'X','0', 'X', '0'},
                 {'X','0', '0', 'X'},
                 {'X','X', '0', '0'}};

        if(!findPath(mat, m, n, 0, 0)) {
            System.out.println("No solution exists");
        } else {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
