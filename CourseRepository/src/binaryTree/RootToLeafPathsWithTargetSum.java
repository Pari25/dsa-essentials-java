package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathsWithTargetSum {

    static class Node
    {
        int key;
        Node left, right;
        Node(int val) {
            this.key = val;
            this.left = null;
            this.right = null;
        }
    }

    private static List<List<Integer>> rootToLeafPaths(Node root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathHelper(root, targetSum, 0, new ArrayList<Integer>(), res);

        return res;
    }

    private static void pathHelper(Node root, int targetSum, int curSum, List<Integer> curList, List<List<Integer>> res) {
        if(root == null) return;

        curList.add(root.key);
        curSum = root.key + curSum;

        if(root.left == null && root.right == null) {
            if(curSum == targetSum) {
                res.add(new ArrayList<>(curList));
            }
        }

        pathHelper(root.left, targetSum, curSum, curList, res);
        pathHelper(root.right, targetSum, curSum, curList, res);

        curList.remove(curList.size() - 1);
    }

    public static void main(String[] args)
    {

/*
            Tree:

              5
          /      \
        4         8
       /         /  \
      11        13   4
     /  \            / \
    7    2            5  1


         */

        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);

        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);

        int sum = 22;
        List<List<Integer>> res = rootToLeafPaths(root, sum);
        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
