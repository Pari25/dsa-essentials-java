package Recursion;


/**
 You are given N tiles of size 1 x M, There is a floor of size N x M which you have to cover with tiles.
 Find the number of ways the floor can be completely covered if you can place the tiles in both horizontal and
 vertical manner.
**/
public class tileFloor {


    private static int tileFloor(int n, int m) {

        if(n == 0 && m == 0) return 1;
        if(n <= 0 || m <= 0) return 0;
        if(n < m) return 1;
        if(n == m) return 2;

        return tileFloor(n - 1, m) + tileFloor(n - m, m);

    }

    public static void main(String[] args) {

        int n = 4, m = 3;
        System.out.println(tileFloor(n, m));
    }
}
