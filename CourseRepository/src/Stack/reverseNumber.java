package Stack;

import java.util.Stack;

public class reverseNumber {

    private static int reverseNumber(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n != 0) {
            stack.push(n % 10);
            n = n / 10;
        }


        Integer res = 0, multiplier = 1;
        while(!stack.isEmpty()) {
            res = stack.pop() * multiplier + res;
            multiplier = multiplier * 10;
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 456;
        int res = reverseNumber(n);
        System.out.println(res);
    }
}
