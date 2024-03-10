package Stack;

import java.util.Stack;

public class StockSpanProblem {

    private static int[] stockSpanUsingDp(int[] arr) {
        int[] res = new int[arr.length];

        res[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]) {
                res[i] = 1;
            } else {
                int rev = i - 1;
                while(rev >= 0 && arr[rev] <= arr[i]) {
                    rev = rev - res[rev];
                }
                res[i] = i - rev;
            }
        }

        return res;
    }

    public static int[] stockSpanUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[arr.length];
        stack.push(0);
        res[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]) {
                res[i] = 1;
                stack.push(i);
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                res[i] = (stack.isEmpty()) ?  (i + 1) : i - stack.peek();
                stack.push(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] res = stockSpanUsingDp(arr);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println();

         res = stockSpanUsingStack(arr);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
