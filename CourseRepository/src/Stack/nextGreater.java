package Stack;

import java.util.Stack;

public class nextGreater {

    private static int[] nextGreater(int[] arr) {

        int[] res = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        res[arr.length - 1] = -1;
        stack.push(arr[arr.length - 1]);
        for(int i = arr.length - 2; i >= 0; i--) {
            int top = stack.peek();
            if(arr[i] < top) {
                res[i] = top;
            } else {
                while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                    stack.pop();
                }
                res[i] = (stack.isEmpty()) ? -1 : stack.peek();
            }
            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 25 };
        int[] res = nextGreater(arr);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println();
    }
}
