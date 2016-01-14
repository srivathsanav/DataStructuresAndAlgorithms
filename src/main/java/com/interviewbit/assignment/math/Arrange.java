package com.interviewbit.assignment.math;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Arrange {
    public static void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i =0; i < a.size(); i++) {
            int newValue =  a.get(i) + (a.get(a.get(i)) % n) * n;
            a.set(i, newValue);
        }
        for (int i =0; i < a.size(); i++) {
            a.set(i, a.get(i)/n);

        }
    }
}
