package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by srivathsan on 22/09/15.
 */
public class ThreeSum {

    public static int threeSumClosest(ArrayList<Integer> a, int b) {
        if (a.size() < 3) {
            return 0;
        }
        double target = b;



        Collections.sort(a);
        double bestDifference = Integer.MAX_VALUE;

        double twoSumReal = 0;
        int j = a.size() -1;

        int startIndex = 0;

        for (int k = 0; k < a.size(); k++) {
            double targetMinusFirst = (double) b - a.get(k);

            for (int i = k + 1; i < a.size(); i++) {
                double second = a.get(i);

                for (; j > i; j--) {
                    double third = a.get(j);

                    double twoSum = (double) second + third;


                    if (Math.abs(twoSum - targetMinusFirst) < bestDifference) {
                        bestDifference = Math.abs(twoSum - targetMinusFirst);
                        twoSumReal = twoSum;
                        startIndex = k;
                    }
                    if (twoSum < targetMinusFirst) {
                        break;
                    } else if (twoSum == targetMinusFirst){
                        return (int)(twoSumReal+(double)a.get(startIndex));

                    }

                }
            }
        }

        return (int)(twoSumReal+(double)a.get(startIndex));
    }


    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8,2, 1, -9, -7, -8, 2, -8, 2, 3, -8,2, 1, -9, -7, -8, 2, -8, 2, 3, -8,2, 1, -9, -7, -8, 2, -8, 2, 3, -8));
       // ArrayList<Integer> first = new ArrayList(Arrays.asList(-1, 2 ,1, -4));
        System.out.println(threeSumClosest(first, -1));

    }
}
