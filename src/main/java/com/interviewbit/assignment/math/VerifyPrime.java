package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class VerifyPrime {
    public int isPrime(int a) {
        if ( a < 2) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a%i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
