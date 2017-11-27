package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class MinDepth {

    public static int minDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }

        if (a.left == null && a.right == null) {
            return 1;
        }
        if (a.left == null || a.right == null) {
            if (a.left == null) {
                return 1+ minDepth(a.right);
            } else {
                return 1+ minDepth(a.left);
            }
        }
        return Math.min(minDepth(a.left), minDepth(a.right)) + 1;
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


      //  root.right.left = null;
       // root.right.right = null;
        System.out.println(minDepth(root));
    }
}
