package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Factorial {
    public int trailingZeroes(int a) {
        if ( a < 0) {
            return 0;
        }
        int val = 0;
        for (int number = 5; ; number*=5) {
            int result = a/number;

            if (result < 1) {
                return val;
            }  else {
                val = val + result;
            }
        }
    }
}
