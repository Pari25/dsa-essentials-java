package Recursion;

import java.util.Scanner;

public class factorial {

    //Time complexity = number = func calls = O(n)
    //Space complexity = max size of call stack = O(n)

    static int fact(int n){
        //base case
        if(n==0){
            return 1;
        }
        //rec case
        int ans = n*fact(n-1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fact(n));
    }


}
