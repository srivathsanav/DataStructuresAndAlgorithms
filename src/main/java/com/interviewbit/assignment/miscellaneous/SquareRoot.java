package com.datastructures;

/**
 * Created by srivathsan on 02/01/17.
 */
public class SquareRoot {

    public static int sqrt(int a) {
        int high = a;
        int low = 0;

        while (low <= high) {
            int mid = (low + high)/2;

            if ((mid * mid) <= a) {
                low = mid + 1;

            } else if ((mid * mid) > a) {
                high = mid - 1;
            } else {
                return  mid;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
