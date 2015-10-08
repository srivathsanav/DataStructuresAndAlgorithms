package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 08/10/15.
 */

public class Pascal1 {
    public static ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> pascalList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    innerList.add(1);
                } else {
                    int value = 0;
                    if ( j <= pascalList.get(i-1).size() - 1) {
                        value = value +  pascalList.get(i-1).get(j);
                    }
                    value = value + pascalList.get(i-1).get(j-1);

                    innerList.add(value);
                }

            }
            pascalList.add(innerList);

        }
        return pascalList;
    }
}
