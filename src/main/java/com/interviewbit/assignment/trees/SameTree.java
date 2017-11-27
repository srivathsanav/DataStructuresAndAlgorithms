package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 22/01/16.
 */
public class SameTree {

    public boolean isSameTreeUtil(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null) {
            return false;
        } else if (b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        } else if (isSameTreeUtil(a.left, b.left) && isSameTreeUtil(a.right, b.right)) {
            return true;
        } else {
            return false;
        }
    }

    public int isSameTree(TreeNode a, TreeNode b) {
        if ( isSameTreeUtil(a, b)) {
            return 1;
        } else {
            return  0;
        }
    }

    public static void main(String[] args) {

    }
}
