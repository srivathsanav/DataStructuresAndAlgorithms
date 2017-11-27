package com.interviewbit.assignment.trees;

/**
 * Created by srivathsan on 21/01/16.
 */
public class InorderNext {

    public static TreeNode findMin(TreeNode a, int value) {
        if (a == null) {
            return  null;
        } else {
            while (a.left != null) {
                a = a.left;
            }
        }
        return a;
    }


    private static TreeNode findCurrent(TreeNode a, int val) {
       while (a != null && a.val != val)  {
           if (val < a.val) {
               a = a.left;
           } else {
               a = a.right;
           }
       }
        if (a!= null && a.val == val) {
            return a;
        }
        return null;
    }

    public static TreeNode getSuccessor(TreeNode root, int b) {
        if (root == null) {
            return null;
        } else {
            TreeNode current = findCurrent(root, b);
            if (current.right != null) {
                return findMin(current.right, b);
            } else {
                TreeNode successor = null;
                TreeNode ancestor = root;

                while (ancestor != current) {
                    if (b < ancestor.val) {
                        successor = ancestor;
                        ancestor = ancestor.left;
                    } else {
                        ancestor = ancestor.right;
                    }
                }
                return successor;
            }
        }

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

        System.out.println(getSuccessor(root, 99).val);
    }
}
