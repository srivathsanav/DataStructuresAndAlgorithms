package com.interviewbit.assignment.trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 24/01/16.
 */
public class CountInversions {

    private static int mergeSort(int a[]) {
        if (a.length < 2)
            return 0;

        int m = (a.length + 1) / 2;
        int left[] = Arrays.copyOfRange(a, 0, m);
        int right[] = Arrays.copyOfRange(a, m, a.length);

        return mergeSort(left) + mergeSort(right) + merge(a, left, right);
    }

    private static  int merge(int a[], int left[], int right[] ) {
        int i = 0, j = 0, count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                a[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                a[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                a[i+j] = left[i];
                i++;
            } else {
                a[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }

    public static int countInversions(ArrayList<Integer> myList) {
        int[] arr = new int[myList.size()];

        for(int i = 0; i < myList.size(); i++) {
            if (myList.get(i) != null) {
                arr[i] = myList.get(i);
            }
        }
       return mergeSort(arr);
    }

    public static void main(String[] args) {
        System.out.println(countInversions(new ArrayList<Integer>(Arrays.asList(2,4,1,3,5))));
    }
}
