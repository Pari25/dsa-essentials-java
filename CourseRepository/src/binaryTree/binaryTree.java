package binaryTree;

import java.util.*;

public class binaryTree {


    static Scanner scanner = new Scanner(System.in);
    static class Node{


        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left = right = null;
        }
    };
//Preorder Build of the Tree Root, Left, Right Tree
    static Node  buildTree(){


        int d = scanner.nextInt();

        if(d==-1){
            return null;
        }

        Node  n = new Node(d);
        n.left = buildTree();
        n.right = buildTree();
        return n;
    }

    static void printPreorder(Node  root){
        if(root==null){
            return;
        }
        System.out.println(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    static void printInorder(Node  root){
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.data + " ");
        printInorder(root.right);
    }

    static void postOrder(Node   root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    static void levelOrder(Node root){

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.data);
            if(n.left != null) {
                queue.add(n.left);
            }
            if(n.right != null) {
                queue.add(n.right);
            }
        }
    }

    static void printRoot2LeafPaths(Node root, ArrayList<Integer> path){

        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            //print the vector
            for(int node:path){
                System.out.print(node + ".");
            }
            System.out.println(root.data + ".");
            return;
        }

        //rec case
        path.add(root.data);
        printRoot2LeafPaths(root.left,path);
        printRoot2LeafPaths(root.right,path);
        //backtracking
        path.remove(path.size()-1);

    }

    static class Counter {
        int count;
        Counter(int count) {
            this.count = count;
        }
    }

    static Node buildTreeFromPreOrder(int[] arr, Counter counter) {

        int val = arr[counter.count++];

        if(val == -1) return null;

        Node node = new Node(val);
        node.left = buildTreeFromPreOrder(arr, counter);
        node.right = buildTreeFromPreOrder(arr, counter);

        return node;
    }

    static Node buildTreeFromLevelOrder(int[] levelOrder) {

        Queue<Node> queue = new LinkedList<>();
        int i = 0;
        Node root = new Node(levelOrder[i++]);
        queue.add(root);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            int left = levelOrder[i++];
            int right = levelOrder[i++];
            if(left != -1) {
                n.left = new Node(left);
                queue.add(n.left);
            }
            if(right != -1) {
                n.right = new Node(right);
                queue.add(n.right);
            }
        }

        return root;
    }

    static int height(Node root) {
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static List<Node> kLevel(Node root, int level, int k, List<Node> result) {

        if(root == null) return result;
        if(level ==  k) {
            result.add(root);
        }

        kLevel(root.left, level + 1, k, result);
        kLevel(root.right, level + 1, k, result);

        return result;
    }



    //Naive Approach : O(n^2)
    static int diameter(Node root) {
        if(root == null) return 0;

        int diameter =  Math.max(diameter(root.left), diameter(root.right));
        diameter = Math.max(diameter, height(root.left) + height(root.right));

        return diameter;
    }

    static class Pair {
        int diameter;
        int height;

        Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    //Optimised Approach : O(n)
    static Pair diameterOptimised(Node root) {
        if(root == null) return new Pair(0, 0);

        Pair left = diameterOptimised(root.left);
        Pair right = diameterOptimised(root.right);

       int resDiameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height);
       int resHeight = Math.max(left.height, right.height) + 1;


        return new Pair(resHeight, resDiameter);
    }


    //Min Depth
    static int minDepth(Node root) {
        if(root == null) return 0;

        if(root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

        if(root.left == null) return (minDepth(root.right) + 1);

        return (minDepth(root.left) + 1);
    }


    public static void main(String[] args) {



        //Node root = buildTree();
        int[] arr = {1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1};

        //1. Build Tree from Pre Order Traversal
        Node root = buildTreeFromPreOrder(arr, new Counter(0));

        //2. Print Pre Order Traversal
        System.out.println("PreOrder");
        printPreorder(root);
        System.out.println();


        //3. Print In Order Traversal
        System.out.println("InOrder");
        printInorder(root);
        System.out.println();


        //4. Print Post Order Traversal
        System.out.println("PostOrder");
        postOrder(root);
        System.out.println();


        //5. Print Level Order Traversal
        System.out.println("Level Order");
        levelOrder(root);
        System.out.println();


        //6. Build Tree from Level Order
        int[] levelOrder = {1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1};
        root = buildTreeFromLevelOrder(levelOrder);
        System.out.println("Level Order after building tree from it");
        levelOrder(root);
        System.out.println();

        //7. Height of tree
        System.out.println("Height of tree:");
        System.out.println(height(root));


        //8. Print Kth level of tree
        System.out.println("Kth Level of tree:");
        List<Node> result = new ArrayList<>();
        List<Node> kLevel = kLevel(root, 0, 2, result);
        for(int i = 0; i < kLevel.size(); i++) {
            System.out.print(kLevel.get(i).data + " ");
        }
        System.out.println();


        //9a. Diameter of tree
        System.out.println("Diameter of tree:");
        System.out.println(diameter(root));


        //9b. Diameter of tree - optimised
        System.out.println("Diameter of tree by optimised approach:");
        System.out.println(diameterOptimised(root).diameter);

        //10. Min Depth
        System.out.println("Min Depth:");
        System.out.println(minDepth(root));


        //7. Print Root to leaf paths
        System.out.println();
        System.out.println("Root To Leaf Paths: ");
        ArrayList<Integer> path= new ArrayList<>();
        printRoot2LeafPaths(root,path);

    }




}
