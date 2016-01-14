package com.interviewbit.assignment.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 28/10/15.
 */
public class Diffk {

    public static int diffPossible(ArrayList<Integer> a, int b) {
        int found = 0;
        int j = a.size() -1;
        for (int i =a.size() -1; i >= 0; i--) {
            for ( j = 0; j < i; j++) {
                if (a.get(i).intValue() - a.get(j).intValue() == b) {
                    return  1;
                } else if  (a.get(i).intValue() - a.get(j).intValue() < b) {
                    break;
                } else if  (a.get(i).intValue() - a.get(j).intValue() > b) {
                   continue;
                }
            }
        }
        return  found;
    }

    public static void main(String[] args) {
        System.out.println(diffPossible( new ArrayList<Integer>(Arrays.asList(0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30, 37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95)), 83));
    }
}
