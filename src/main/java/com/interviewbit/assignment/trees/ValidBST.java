package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 21/01/16.
 */
public class ValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(7);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(7);
        root.right.right = new TreeNode(100);
        root.left.left.left = null;
        root.right.right.right = null;
        System.out.println(isValidBST(root));
    }

    public static int isValidBST(TreeNode a) {
       if (isValidBSTUtil(a, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
           return 1;
       } else {
           return 0;
       }
    }

    public static boolean isValidBSTUtil(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        } else if (root.val > minVal && root.val <= maxVal &&
                isValidBSTUtil(root.left, minVal, root.val) &&
                isValidBSTUtil(root.right, root.val, maxVal)) {
            return true;
        } else {
            return false;
        }
    }
}

