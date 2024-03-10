package binaryTree;

public class MirrorTree {

    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    private boolean areMirror(Node a, Node b) {

        if(a == null && b == null) return true;
        if(a != null && b != null) {
            return a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left);
        }

        return false;
    }


    // Driver code to test above methods
    public static void main(String[] args)
    {
        MirrorTree tree = new MirrorTree();
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        if (tree.areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
