package binaryTree;

public class ConvertToMirror {

    static class Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    void inOrder(Node node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    Node mirror(Node root) {
        if(root == null) return root;

        Node right = root.right;
        root.right = root.left;
        root.left = right;
        root.left = mirror(root.left);
        root.right = mirror(root.right);

        return root;
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        ConvertToMirror tree = new ConvertToMirror();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println(
                "Inorder traversal of the constructed tree is");
        tree.inOrder(root);
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror(root);

        /* print inorder traversal of the minor tree */
        System.out.println(
                "Inorder traversal of the mirror tree is");
        tree.inOrder(root);
    }
}
