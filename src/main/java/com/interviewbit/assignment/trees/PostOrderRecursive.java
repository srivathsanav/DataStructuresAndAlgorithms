package com.interviewbit.assignment.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by srivathsan on 21/01/16.
 */
public class PostOrderRecursive {

    public static ArrayList<Integer> inorderTraversal(TreeNode a) {
        if (a == null) {
            return  null;
        }
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        TreeNode previous = null;
        ArrayList<Integer> list = new ArrayList<Integer>();


        treeNodes.push(a);
        //now define the key loop
        while(!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.peek();
            //firstly make sure it is not a null
            if(current == null)
                treeNodes.pop();
                //now check if it is leaf node to be printed
            else if(current.left==null && current.right==null) {
                //always check the current's left/child not the class scope ones!
               list.add(current.val);
                treeNodes.pop();//need to pop it whenever we print it out
            }
            //it is always associated to the pointer not the value in the class scope
            //3rd, check if previous pointer is our left child, if so, we need push right child for processing
            else if(current.left == previous)
                treeNodes.push(current.right);
                //4th, if previous pointer is current pointer's right child, print itself!
            else if(current.right == previous) {
               list.add(current.val);
                treeNodes.pop();
            }
            //otherwise, push the left child for processing!
            else
                treeNodes.push(current.left);

            //almost forgot to update the previous pointer
            previous = current;
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
