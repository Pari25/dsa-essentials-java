package Stack;

import java.util.Stack;

public class duplicateParenthesis {

    private static boolean duplicateParenthesis(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()) {
            if(ch == ')') {
                int counter = 0;
                while(!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    counter++;
                }
                if(counter == 0) return true;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "((a+b)+((c+d)))";
        System.out.println(duplicateParenthesis(s));
    }
}
