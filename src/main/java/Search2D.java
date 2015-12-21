package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 20/10/15.
 */
public class Search2D {

    public static int searchMatrix(List<ArrayList<Integer>> a, int b) {

        int low = 0; int high = a.size() -1 ;
        int mid = 0;

        while (low <= high) {
            mid = (high +low) /2 ;
            if (a.get(mid).get(0) == b) {
                return 1;
            } else  if (a.get(mid).get(0) < b) {
                low = mid +1;
            } else {
                high = mid - 1;
            }
            if (low == high) {
                break;
            }
        }
        int highValue = 0;
        int lowValue = low;
        if (high > 0)
            highValue = high;
        int row = 0;
        if (low > 0) {
            row = low -1 ;
        } else {
            row = low;
        }

         low = 0;  high = a.get(0).size() -1 ;
         mid = 0;

        if (binarySearch(a, b, low, high, row)) return 1;

        if (lowValue == 0) {
            return  0;
        }

        row = highValue;

        low = 0;  high = a.get(0).size() -1 ;
        mid = 0;

        if (binarySearch(a, b, low, high, row)) return 1;
        return  0;
    }

    private static boolean binarySearch(List<ArrayList<Integer>> a, int b, int low, int high, int row) {
        int mid;
        while (low <= high) {
            mid = (high +low) /2 ;
            if (a.get(row).get(mid) == b) {
                return true;
            } else  if (a.get(row).get(mid) < b) {
                low = mid +1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> a  = new ArrayList<ArrayList<Integer>>();



        a.add(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 4, 4, 6, 7, 8)));
        a.add(new ArrayList<Integer>(Arrays.asList(10, 18, 19, 22, 22, 24, 27, 27, 27)));
        a.add(new ArrayList<Integer>(Arrays.asList(28, 28, 29, 29, 29, 32, 34, 35, 36)));
        a.add(new ArrayList<Integer>(Arrays.asList(37, 37, 40, 40, 43, 46, 46, 47, 48)));
        a.add(new ArrayList<Integer>(Arrays.asList(49, 51, 53, 53, 55, 55, 60, 62, 62)));
        a.add(new ArrayList<Integer>(Arrays.asList(64, 68, 70, 70, 73, 77, 81, 82, 82)));
        a.add(new ArrayList<Integer>(Arrays.asList(84, 86, 88, 90, 95, 96, 96, 99, 100)));

        System.out.println(searchMatrix(a, 84));
    }


}
