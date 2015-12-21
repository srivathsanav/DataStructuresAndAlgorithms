package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 16/10/15.
 */
public class MaxSum {

   /* public int maxSubArray(final List<Integer> a) {
        int maxSum = Integer.MIN_VALUE;
        boolean pauseCurrentSeq = false;
        for (int i = 0; i < a.size(); i++) {
            if ( a.get(i) > maxSum) {
                maxSum = a.get(i);
            } else if ((maxSum + a.get(i)) > maxSum && !pauseCurrentSeq ){
                maxSum = maxSum+ a.get(i);
            } else {
                pauseCurrentSeq = true;
            }
        }

    }*/


   /* public static int maxSubArray(final List<Integer> a) {
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> sums = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++) {
            int currentSum = a.get(i);
            if (currentSum > maxSum){
                sums.add(currentSum);
                maxSum = currentSum;
            }
            for (int j = i+1; j < a.size(); j++) {
                currentSum = currentSum+a.get(j);
                if (currentSum > maxSum) {
                    sums.add(currentSum);
                    maxSum = currentSum;
                }
            }
        }

    return maxSum;

}*/

    // A Divide and Conquer based program for maximum subarray sum problem


    // A utility funtion to find maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }

    // A utility funtion to find maximum of three integers
    static int max(int a, int b, int c) { return max(max(a, b), c); }

    // Find the maximum possible sum in arr[] auch that arr[m] is part of it
    static int maxCrossingSum(List<Integer> arr, int l, int m, int h)
    {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--)
        {
            sum = sum + arr.get(i);
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m+1; i <= h; i++)
        {
            sum = sum + arr.get(i);
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left and right of mid
        return left_sum + right_sum;
    }

    static int maxSubArraySum(List<Integer> arr, int l, int h)
    {
        // Base Case: Only one element
        if (l == h)
            return arr.get(l);

        // Find middle point
        int m = (l + h)/2;

   /* Return maximum of following three possible cases
      a) Maximum subarray sum in left half
      b) Maximum subarray sum in right half
      c) Maximum subarray sum such that the subarray crosses the midpoint */
        return max(maxSubArraySum(arr, l, m),
                maxSubArraySum(arr, m + 1, h),
                maxCrossingSum(arr, l, m, h));
    }
    public static int maxSubArray(final List<Integer> a) {
        return  maxSubArraySum(a, 0, a.size() - 1);
    }

    public static void main(String[] args) {

        System.out.println(maxSubArray(Arrays.asList(-2, 1, -3, 4, -1)));
    }
}
