package com.interviewbit.assignment.math;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Sieve {
    public ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= a; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
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
