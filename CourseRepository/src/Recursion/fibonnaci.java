package Recursion;

public class fibonnaci {

    //Time complexity = number = func calls = O(2 ^ n)
    //Space complexity = max size of call stack = O(n) because funcs will start getting removed from call stack once it returns the ans.

    int fibo(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibo(n - 1) + fibo(n - 2);
    }

    static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int f1 = fib(n-1);
        int f2 = fib(n-2);
        return f1 + f2;
    }

    public static void main(String[] args) {

        System.out.println(fib(10));
    }
}
