package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class MaxDepth {

    public static int maxDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }
        return Math.max(maxDepth(a.left), maxDepth(a.right)) + 1;
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

        System.out.println(maxDepth(root));
    }
}
