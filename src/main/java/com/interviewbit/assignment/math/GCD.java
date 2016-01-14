package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class GCD {
    public int gcd(int a, int b) {
        if ( a < b) {
            int temp = b;
            b = a;
            a= temp;
        }
        if (b ==0 ){
            return a;
        }

        return gcd (a%b, b);
    }
}
