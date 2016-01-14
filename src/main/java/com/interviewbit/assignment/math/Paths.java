package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Paths {
    public int uniquePaths(int a, int b) {
        if (a == 0 && b <=1) {
            return 1;
        } else if (a==0 && b > 1) {
            return 0;
        } else if (b==0 && a <= 1) {
            return 1;
        }else if (b==0 && a > 1) {
            return 0;
        } else if ((a ==1 || b == 1)) {
            return 1;
        }

        int val = a+b -2;
        int ones = b -1;
        int finalVal = (int) (fact(val)/(fact (ones) *fact(val-ones)));
        return finalVal;
    }

    public double fact(int n) {
        if ( n==1)
            return 1;
        return fact (n-1)* n;
    }
}
