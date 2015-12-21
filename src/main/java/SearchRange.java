package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 20/09/15.
 */
public class SearchRange {
    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int value = binarySearch(a, b);
        if (value == -1) {
            results.add(-1);
            results.add(-1);
        } else {
            int lowerMostIndex = binarySearch1(a, b, 0, value - 1, -1);
            int upperMostIndex = binarySearch2(a, b, value + 1, a.size() - 1, -1);
            if (lowerMostIndex == -1) {
                results.add(value);
            } else {
                results.add(lowerMostIndex);
            }
            if (upperMostIndex == -1) {
                results.add(value);
            } else {
                results.add(upperMostIndex);
            }
        }
        return results;
    }

    private static int binarySearch(List<Integer> a, int b) {
        if (a.size() == 0) {
            return -1;
        }
        int high = a.size() - 1;
        int low = 0;
        while (low <= high) {
            int mid = high - ((high - low)/2);

            if (b == a.get(mid)) {
                return mid;
            } else if (b < a.get(mid)) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }

    private static int binarySearch1(List<Integer> a, int b, int start, int end, int currentVal) {
        int high = end;
        int low = start;
        while (low <= high) {
            int mid = high - ((high - low)/2);

            if (b == a.get(mid)) {
                currentVal = mid;
                high = mid - 1;
            } else if (b < a.get(mid)) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return currentVal;
    }

    private static int binarySearch2(List<Integer> a, int b, int start, int end, int currentVal) {
        int high = end;
        int low = start;
        while (low <= high) {
            int mid = high - ((high - low)/2);

            if (b == a.get(mid)) {
                currentVal = mid;
                low = mid + 1;
            } else if (b < a.get(mid)) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return currentVal;
    }

    public static void main(String args[]) {
         List<Integer> arrays = Arrays.asList(5, 5, 7, 8, 8,  10);
         System.out.println(searchRange(arrays, 5));
    }
}
