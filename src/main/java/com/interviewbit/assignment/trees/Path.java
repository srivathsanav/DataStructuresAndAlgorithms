package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class Path {
    public static int hasPathSum(TreeNode a, int b) {

        if (a == null) {
            return 0;
        }
        if (a.val == b && a.left == null && a.right == null) {
           return 1;
        }

        int leftVal =   hasPathSum(a.left, b - a.val) ;
        if (leftVal == 1) {
            return 1;
        }
        int rightVal =    hasPathSum(a.right, b - a.val);

        if (rightVal == 1) {
            return 1;
        } else {
            return 0;
        }



    }


    public static int hasPathSum1(TreeNode a, int b) {
        if (a == null) {
            if ( b == 0) {
                return 1;
            } else {
                return 0;
            }
        }
       return hasPathSum(a, b );

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);

        root.left = new TreeNode(98);
        root.right = new TreeNode(102);
        root.left.left = new TreeNode(96);
        root.left.right = new TreeNode(99);

        root.left.left.left = null;
        root.left.left.right = null;

        root.left.right.left = null;
        root.left.right.right = null;


        root.right.left = new TreeNode(200);
        root.right.right =  new TreeNode(300);

        root.right.left.left = null;
        root.right.left.right = null;

        root.right.right.left =  null;
        root.right.right.right = null;

        System.out.println(hasPathSum1(root, 502));
    }
}
