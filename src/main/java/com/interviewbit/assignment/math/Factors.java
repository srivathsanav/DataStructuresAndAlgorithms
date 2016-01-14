package com.interviewbit.assignment.math;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Factors {
    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> myList = new ArrayList();
        ArrayList<Integer> secondList = new ArrayList();

        if (a == 0) {
            myList.add(0);
            return myList;
        }
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a%i == 0) {
                myList.add(i);
                if ((a/i) != i) {
                    secondList.add(a/i);
                }
            }
        }
        for (int i = secondList.size() - 1; i >= 0 ; i--) {
            myList.add(secondList.get(i));
        }
        return myList;
    }
}
