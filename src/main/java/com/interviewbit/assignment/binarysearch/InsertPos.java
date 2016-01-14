package com.interviewbit.assignment.binarysearch;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class InsertPos {
    public static int searchInsert(ArrayList<Integer> a, int b) {
        if (a.size() == 0) {
            return 1;
        }
        int low = 0;
        int high = a.size() - 1;

        while ( low <= high) {
            int mid = low + ((high - low)/2) ;
            if (a.get(mid) == b) {
                return mid;
            } else  if (a.get(mid) < b) {
                low = mid + 1;
            } else  if (a.get(mid) > b) {
                high = mid - 1;
            }
        }
        return high+1;
    }
}
