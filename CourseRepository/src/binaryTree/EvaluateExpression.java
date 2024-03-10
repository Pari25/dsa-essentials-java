package binaryTree;

public class EvaluateExpression {

    private static class Node
    {
        String data;
        Node left, right;

        public Node(String data)
        {
            this.data = data;
            left = right = null;
        }
    }

    private static int evaluateExpression(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        }
        if(root.data.equals("*")) {
            return evaluateExpression(root.left) * evaluateExpression(root.right);
        }
        if(root.data.equals("+")) {
            return evaluateExpression(root.left) + evaluateExpression(root.right);
        }
        if(root.data.equals("-")) {
            return evaluateExpression(root.left) - evaluateExpression(root.right);
        }

        return evaluateExpression(root.left) / evaluateExpression(root.right);
    }



    public static void main(String[] args)
    {

        // Creating a sample tree
        Node root = new Node("+");
        root.left = new Node("*");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("-4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("20");
        System.out.println(evaluateExpression(root));

        root = null;

        // Creating a sample tree
        root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("/");
        root.right.right.left = new Node("20");
        root.right.right.right = new Node("2");
        System.out.println(evaluateExpression(root));
    }
}
