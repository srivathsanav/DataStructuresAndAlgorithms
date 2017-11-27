package com.interviewbit.assignment.trees;

import java.util.ArrayList;

/**
 * Created by srivathsan on 22/01/16.
 */
public class Path2 {



    public static void pathSum(TreeNode a, int sum, ArrayList<Integer> temp,  ArrayList<ArrayList<Integer>> result) {


        if (sum == 0 && a.left == null && a.right == null) {
            ArrayList<Integer> current = new ArrayList<Integer>(temp);
            result.add(current);
        }

        if (a.left != null) {
            temp.add(a.left.val);
            pathSum(a.left, sum - a.left.val, temp, result);
            temp.remove(temp.size() - 1);

        }

        if (a.right != null) {
            temp.add(a.right.val);
            pathSum(a.right, sum - a.right.val, temp, result);
            temp.remove(temp.size() -1);

        }




    }


    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode a, int b) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();

        if (a == null) {
            return result;
        }
         ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(a.val);
         pathSum(a, b- a.val,list, result);
            return result;
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

        System.out.println(pathSum(root, 297));
    }

}
