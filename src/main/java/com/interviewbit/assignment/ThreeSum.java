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
        int target = b;

        Collections.sort(a);
        long bestDifference = Integer.MAX_VALUE;
        long closest = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {
            int first = a.get(i);
            long difference = target - first;
            int k = a.size() - 1;

            for (int j = i+1; j < a.size(); j++) {
                long second = a.get(j);

                for (; k > j; k--) {
                    long third = a.get(k);
                    if ((second + third - difference) < bestDifference) {
                        bestDifference = second + third;
                        closest = bestDifference + first;
                        bestDifference = Math.abs(bestDifference);
                    }
                    if ((second + third) < difference) {
                        break;
                    } else if ((second + third) == difference) {
                        return target;
                    }


                }

            }
        }


        return (int)closest;
    }


    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8));
        System.out.println(threeSumClosest(first, -1));

    }
}
