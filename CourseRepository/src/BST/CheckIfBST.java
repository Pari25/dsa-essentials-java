package BST;

public class CheckIfBST {

    static class Node {
        public int data;
        public Node left, right;
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    private static boolean isBST(Node root) {

        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTHelper(Node root, int min, int max) {

        if(root == null) return true;
        return root.data >= min && root.data < max
                && isBSTHelper(root.left, min, root.data)
                && isBSTHelper(root.right, root.data, max);
    }

    public static void main(String[] args)
    {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);

        // root->right->left = newNode(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // Function call
        if (isBST(root)) {
            System.out.print("Is BST");
        }
        else {
            System.out.print("Not a BST");
        }
    }
}
