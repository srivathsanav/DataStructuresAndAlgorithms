package com.interviewbit.assignment;

/**
 * Created by srivathsan on 20/09/15.
 */
public class SquareRootBinarySearch {
    public static int sqrt(int a) {
        long low = 1;
        long high = a;
        while (low <= high) {
            long mid = high - ((high-low)/2);
            if ((mid * mid) < a) {
                low = mid + 1;
            } else if ((mid * mid) > a) {
                high = mid - 1;
            } else {
                return (int)mid;
            }
        }
        return (int)low -1;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }
}
