package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 08/10/15.
 */

public class Positive {
    public int firstMissingPositive(ArrayList<Integer> a) {
        boolean[] numberArray = new boolean[10000000];
        for (int i =0 ; i < a.size(); i++) {
            if (a.get(i) > 0 ) {
                numberArray[a.get(i) - 1] = true;
            }
        }

        for (int i=0; i< numberArray.length; i++) {
            if (!numberArray[i]) {
                return i+1;
            }
        }
        return 0;
    }
}
