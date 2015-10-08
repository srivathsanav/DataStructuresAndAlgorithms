package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 22/09/15.
 */
public class NumRange {

    public static int numRange(ArrayList<Integer> a, int b, int c) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            sum = 0;
            if ((a.get(i) >= b) && (a.get(i) <= c)) {
                count++;
            } else if (a.get(i) > c) {
                continue;
            }

            sum = sum + a.get(i);
            for (int j = i + 1; j < a.size(); j++) {
                if ((sum + a.get(j)) >= b && (sum + a.get(j) <= c)) {
                    sum = sum + a.get(j);
                    count++;
                } else if ((sum + a.get(j) > c)) {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList(Arrays.asList(76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66));
        System.out.println(numRange(first, 98, 290));
    }

}
