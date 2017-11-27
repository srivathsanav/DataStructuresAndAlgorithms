package com.datastructures;

/**
 * Created by srivathsan on 08/10/16.
 */
public class BinarySearch {

    private boolean doBinarySearch(int a[], int low,  int high, int item) {
        int mid = (low + high) /2 ;
        if (low > high) {
            return false;
        }
        if (a[mid] == item) {
            return true;
        } else if (a[mid] > item) {
              return doBinarySearch(a, low, mid -1, item);
        } else {
             return doBinarySearch(a, mid+1, high, item);
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        System.out.printf(new BinarySearch().doBinarySearch(a, 0, a.length-1, 1) + "");
    }
}
