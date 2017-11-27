package com.interviewbit.assignment.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by srivathsan on 21/01/16.
 */
public class InorerWithoutRecursion {
    public static ArrayList<Integer> inorderTraversal(TreeNode a) {
        if (a == null) {
            return  null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> items = new Stack<TreeNode>();
        boolean proceed = true;
        while (a != null || !items.isEmpty()) {
            if (a != null) {
                items.push(a);
                a = a.left;
            } else {
                TreeNode node = items.peek();
                if (node.right == null) {
                    list.add(items.pop().val);
                } else {
                    a = node.right;
                }
            }
        }
        return list;
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

        System.out.println(inorderTraversal(root));
    }
}
