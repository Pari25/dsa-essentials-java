package Stack;

import java.util.Stack;

public class maxAreaInHistogram {

    private static int maxArea(int[] arr) {

        int n = arr.length;
        int[] leftSpan = new int[n];
        int[] rightSpan = new int[n];

        Stack<Integer> stack = new Stack<>();
        leftSpan[0] = 1;
        stack.push(0);

        //filling leftSpan
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[stack.peek()]) {
                leftSpan[i] = 1;
            } else {
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }
                leftSpan[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            }
            stack.push(i);
        }

        //filling rightSpan
        stack = new Stack<>();
        rightSpan[n - 1] = 1;
        stack.push(n - 1);
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > arr[stack.peek()]) {
                rightSpan[i] = 1;
            } else {
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }
                rightSpan[i] = (stack.isEmpty()) ? (n - i) : (stack.peek() - i);
            }
            stack.push(i);
        }




        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, (leftSpan[i] + rightSpan[i] - 1) * arr[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr =     {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxArea(arr));
    }
}
