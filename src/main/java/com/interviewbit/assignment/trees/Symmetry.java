package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class Symmetry {

    public static boolean isSymmetricUtil(TreeNode left, TreeNode right) {

        if (left== null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }

    public int isSymmetric(TreeNode a) {
        if (a == null) {
            return 1;
        }
        if ( isSymmetricUtil(a.left, a.right)) {
            return 1;
        } else {
            return  0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(10);



        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left =  null;
        root.left.right.right =  null;



        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left =  null;
        root.right.right.right =  null;

        System.out.println(new Symmetry().isSymmetric(root));
    }
}
