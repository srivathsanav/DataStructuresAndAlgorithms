package com.interviewbit.assignment.trees;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 23/01/16.
 */
public class ArrayToBST {

    public static TreeNode sortedArrayToBST(final List<Integer> a, int start, int end) {

        if ( end < start)
            return null;
        int middle = (start + end) /2;
         TreeNode temp = new TreeNode(a.get(middle));
        temp.left = sortedArrayToBST(a,start, middle -1);
        temp.right = sortedArrayToBST(a, middle+1, end);

        return temp;


    }

    public static TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a.size() == 0) {
            return null;
        }
       TreeNode temp = sortedArrayToBST(a,0, a.size() -1);
        return temp;
    }

    public static void main(String[] args) {

         sortedArrayToBST(Arrays.asList(1,2,3,4));
    }
}
