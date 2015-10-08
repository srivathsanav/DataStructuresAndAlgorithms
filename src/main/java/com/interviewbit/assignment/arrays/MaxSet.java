package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 08/10/15.
 */

public class MaxSet {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> maxSets = new ArrayList<ArrayList<Integer>>(
                a.size());
        for (int i = 0; i < maxSets.size(); i++) {
            maxSets.add(i, new ArrayList<Integer>());
        }
        int maxSetIndex = 0;
        boolean found = false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                if (!found) {
                    maxSets.add(new ArrayList<Integer>());
                    found = true;
                }
                maxSets.get(maxSetIndex).add(a.get(i));

            } else if (found) {
                if ( a.get(i) > 0) {
                    maxSets.get(maxSetIndex).add(a.get(i));
                }
                maxSetIndex++;
                found = false;
            }
        }
        long sum[] = new long[maxSets.size()];
        for (int i = 0; i < maxSets.size(); i++) {
            sum[i] = 0;
            for (int j = 0; j < maxSets.get(i).size(); j++) {
                sum[i] = sum[i] + maxSets.get(i).get(j);
            }
        }
        long maxSum = 0;
        int maxSumIndex = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > maxSum) {
                maxSum = sum[i];
                maxSumIndex = i;
            } else if (sum[i] == maxSum) {
                if (maxSets.get(maxSumIndex).size() < maxSets.get(i).size()) {
                    maxSumIndex = i;
                }

            }
        }
        if (maxSets.size() > 0) {
            return maxSets.get(maxSumIndex);
        }
        return new ArrayList<Integer>();
    }
}
