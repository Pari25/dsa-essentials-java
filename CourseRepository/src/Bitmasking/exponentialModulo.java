package Bitmasking;

public class exponentialModulo {

    private static int powerModulo(int x, int y, int mod)
    {
        int result = 1;
        while(y > 0) {
            result *= (x % mod);
            result = (result % mod);
            y--;
        }

        return result % mod;

    }

    public static void main(String[] args) {
        int x = 12, y = 2, mod = 5;
        System.out.println(powerModulo(x, y, mod));
    }

}
