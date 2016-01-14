package com.interviewbit.assignment.stacks_queues;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 03/11/15.
 */
public class Rain {

    public static int trap(final List<Integer> a) {

        int maxRight[] = new int[a.size()];

        int maxLeft[] = new int[a.size()];

        int maximum = Integer.MIN_VALUE;
        for (int i =0  ; i < a.size() ; i++) {
            if (maximum < a.get(i)) {
                maximum = a.get(i);
            }
            maxLeft[i] = maximum;
        }
         maximum = Integer.MIN_VALUE;

        for (int i =a.size() -1  ; i > 0 ; i--) {
            if (maximum < a.get(i)) {
                maximum = a.get(i);
            }
            maxRight[i] = maximum;
        }

        int area = 0;
        for (int i =1; i < a.size() -1; i++) {
            int mimimum = Math.min(maxLeft[i-1], maxRight[i+1]);
            int currentArea = ( mimimum - a.get(i) > 0) ? mimimum - a.get(i) : 0;
            area = area + currentArea;
        }
        return  area;
    }

    public static void main(String[] args) {
        System.out.println(trap(Arrays.asList(3, 0, 0, 2, 0, 4)));
    }




}
