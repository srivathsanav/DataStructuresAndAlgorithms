package com.interviewbit.assignment.arrays;

/**
 * Created by srivathsan on 15/10/15.
 */
public class SearchNumOccurrence {
   static int count = 0;

    static int  searchNumOccurrence(int[] V, int k, int start, int end) {
        count ++;
        if (start > end) return 0;
        int mid = (start + end) / 2;
        if (V[mid] < k) return searchNumOccurrence(V, k, mid + 1, end);
        if (V[mid] > k) return searchNumOccurrence(V, k, start, mid - 1);
        return searchNumOccurrence(V, k, start, mid - 1);
    }

    public static void main(String[] args) {
        int V[] = new int[10];
        searchNumOccurrence(V, 0, 0, V.length-1);
        System.out.println(count);
    }
}
