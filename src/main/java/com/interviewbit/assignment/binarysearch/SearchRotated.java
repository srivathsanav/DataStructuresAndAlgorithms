package com.interviewbit.assignment.binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 20/10/15.
 */
public class SearchRotated {

    public static int search(final List<Integer> a, int b) {
        if (a.size() == 0) {
            return  -1;
        }
        if (a.size() ==1 ) {
            if (a.get(0) == b ) {
                return  0;
            } else{
                return  -1;
            }
        }
        int index = -1;
        int low = 0 ; int high = a.size() - 1;
        int n = a.size() ;
        for (int i = 0; i < a.size(); i++) {
            int mid = (high + low) / 2;
            int previous = ( mid - 1 + n) % n;
            int next = (mid +1) % n;
            if (a.get(low) < a.get(high)) {
                index =  low;
                break;
            }  else if (a.get(mid) < a.get(next) && a.get(mid) < a.get(previous)) {
                index =  mid;
                break;
            } else if (a.get(mid) > a.get(low)) {
                low = mid +1;
            } else if (a.get(mid) < a.get(high)) {
                high = mid - 1;
            }
        }
        if (index == -1) {
            return  -1;
        }
         int foundIndex  = binarySearch(a,b,0, index -1 );
        if (foundIndex == -1) {
            foundIndex = binarySearch(a,b,index,a.size() -1);
        }
        return ((foundIndex != -1) ? foundIndex : -1);
    }


    private static int binarySearch(List<Integer> a, int b, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (high +low) /2 ;
            if (a.get(mid) == b) {
                return mid;
            } else  if (a.get(mid) < b) {
                low = mid +1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100), 202));
    }
}
