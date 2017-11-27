package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class DepthOfBinaryTree {

    public static int isBalanced(TreeNode root) {
        if (root == null)
            return 1;

        if (getHeight(root) == -1)
            return 0;

        return 1;
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);

        root.left = new TreeNode(98);
        root.right = null;
        root.left.left = new TreeNode(96);
        root.left.right = new TreeNode(99);

        root.left.left.left = null;
        root.left.left.right = new TreeNode(97);

        root.left.right.left = null;
        root.left.right.right = null;


        //root.right.left = null;
        //root.right.right = null;

        System.out.println(isBalanced(root));
    }
}
