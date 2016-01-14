package com.interviewbit.assignment.HackerEarthProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by srivathsan on 23/09/15.
 */
public class QuickSort {

    public static int kthsmallest(final List<Integer> a, int k) {
        return kthsmallest(a, k, 0, a.size()-1);
    }

    public static int kthsmallest(final List<Integer> a, int k, int l, int r) {
        if (k > 0 && k <= (r-1+1)) {
            int position = partition(a, l, r);
            if (position-1 == k-1) {
                return a.get(position);
            }
            if (position-1 > k-1) {
                return kthsmallest(a, k, l, position - 1);
            } else {
                return kthsmallest(a, k-position-1+l, position + 1, r);
            }
        }
        return  -1;
    }

    public static int partition(List<Integer> arr, int l, int r) {
        int x = arr.get(r), i = l; int count = 0;
        for (int j = l; j <= r - 1; j++) {
            if (arr.get(j) <= x) {
                swap(arr, i, j);
                i++;count++;
            }
        }
        swap(arr, i, r);
        return i;

    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList(Arrays.asList( 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
        System.out.println(kthsmallest(first, 9));

        Collections.sort(first);
        System.out.println(first.get(9 - 1));
    }
}
