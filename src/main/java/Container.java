package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 29/10/15.
 */
public class Container {

    public static int maxArea(ArrayList<Integer> a) {
        int low = 0;
        int high = a.size() -1;
        int maxArea = 0;
        int width = 0;

        while (low < high)  {
            maxArea = Math.max(maxArea, (high - low) *  Math.min(a.get(high), a.get(low)));
            if (a.get(high) < a.get(low)) {
                high = high -1;
            } else {
                low = low +1;
            }
        }
        return  maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new ArrayList<Integer>(Arrays.asList(3, 5, 2, 7, 1))));
    }
}
