package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root, TreeNode main) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left, main);
        invertTree(root.right, main);
        return main;
    }

    public static TreeNode invertTree(TreeNode root) {
       return invertTree(root, root);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(98);
        root.right = new TreeNode(102);
        root.left.left = new TreeNode(96);
        root.left.right = new TreeNode(99);

        root.left.left.left = null;
        root.left.left.right = new TreeNode(97);

        root.left.right.left = null;
        root.left.right.right = null;


        root.right.left = null;
        root.right.right = null;
        System.out.println(invertTree(root));
    }

}

