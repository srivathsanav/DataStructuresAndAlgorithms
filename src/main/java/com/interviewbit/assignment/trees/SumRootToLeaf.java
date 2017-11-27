package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class SumRootToLeaf {


    public static int sumNumbers(TreeNode a, int currentSum, int finalSum) {
        if (a == null)
            return finalSum;
        currentSum = (currentSum * 10 + a.val) %1003;

        if (a.left == null && a.right == null) {
            finalSum = (finalSum + currentSum) % 1003;
            return finalSum;
        }

        finalSum = sumNumbers(a.left, currentSum, finalSum) %1003 + sumNumbers(a.right, currentSum , finalSum) %1003;
        return finalSum %1003;

    }

    public static int sumNumbers(TreeNode a) {
        if (a == null) {
            return 0;
        }

        return sumNumbers(a,  0, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = null;
        root.right = new TreeNode(2);



        root.right.left = null;
        root.right.right =  null;



        System.out.println(sumNumbers(root));
    }
}
