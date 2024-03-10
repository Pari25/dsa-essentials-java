package Stack;

import java.util.Stack;

public class reverseStack {

    private static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int element = stack.pop();
        reverseStack(stack);
        insertAtBottomStack(stack, element);
    }

    private static void insertAtBottomStack(Stack<Integer> stack, Integer val) {

        if(stack.isEmpty()) {
            stack.push(val);
            return;
        }

        Integer element = stack.pop();
        insertAtBottomStack(stack, val);
        stack.push(element);
    }

    private static void printStack(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverseStack(stack);
        printStack(stack);
    }
}
