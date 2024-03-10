package Stack;

import java.util.Stack;

public class insertAtBottomStack {

    private static void insertAtBottomStack(Stack<Integer> stack, Integer num) {
        if(stack.isEmpty()) {
            stack.push(num);
            return;
        }

        Integer element = stack.pop();
        insertAtBottomStack(stack, num);
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

        insertAtBottomStack(stack, 4);
        printStack(stack);
    }
}
