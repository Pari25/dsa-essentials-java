package BackTracking;


//Calculate no. of ways to reach from top cell to bottom cell, given you can only move right or down by 1 step.
public class grid {

    //Below complexity: O(2 ^ (m + n))
    private static int waysInGrid(int m, int n, int row, int col) {

        if(row == m - 1 || col == n - 1) {
            return 1;
        }

        return waysInGrid(m, n, row, col + 1) + waysInGrid(m, n, row + 1, col);
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(waysInGrid(m, n, 0, 0));
    }

    //NOTE: It can be solved using dp in O(n^2). It can also be solved in linear time by using maths formula:

    // total steps = (m - 1) + (n - 1)
    // no. of ways in which steps can e arranged, given that we have (m-1) steps of one kind and (n - 1) steps of other kind,
    //  ways = ((m -1 + n -1)! / ((m-1)! * (n-1)!)
}
