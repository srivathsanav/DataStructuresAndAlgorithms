package com.interviewbit.assignment.math;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> primeSum = new ArrayList();

        if (A < 2) {
            return primeSum;
        }
        for (int i = 2; i < A; i++) {
            if (isPrime(i) && isPrime(A-i)) {
                primeSum.add(i);
                primeSum.add(A-i);
                return primeSum;
            }
        }
        return primeSum;
    }

    private boolean isPrime(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a%i == 0) {
                return false;
            }
        }
        return true;
    }
}
