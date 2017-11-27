package com.interviewbit.assignment.trees;

import java.util.Stack;

/**
 * Created by srivathsan on 23/01/16.
 */
public class KthSmallest2 {

    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        int result = 0;
        while (!nodes.isEmpty() || root != null) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                TreeNode t = nodes.pop();
                k--;
                if ( k == 0) {
                    return t.val;
                }
                root = t.right;
            }
        }
        return result;
    }
}
