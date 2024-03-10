package binaryTree;

public class RemoveHalfNodes {

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Node root;

    private Node removeHalfNodes(Node root) {

        if(root == null) return root;
        if(root.left  == null && root.right == null) return root;

        if(root.left != null && root.right != null) {
            root.left = removeHalfNodes(root.left);
            root.right = removeHalfNodes(root.right);
            return root;
        }

        Node newNode = null;
        if(root.left == null) {
            newNode = root.right;
            root.right = null;
        } else {
            newNode = root.left;
            root.left = null;
        }

        return removeHalfNodes(newNode);
    }

    private void printInorder(Node root) {

        if(root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String args[])
    {
        RemoveHalfNodes tree = new RemoveHalfNodes();
        Node NewRoot = null;
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        System.out.println("the inorder traversal of tree is ");
        tree.printInorder(tree.root);

        NewRoot = tree.removeHalfNodes(tree.root);

        System.out.print("\nInorder traversal of the modified tree \n");
        tree.printInorder(NewRoot);
    }




}
