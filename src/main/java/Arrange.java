package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 30/10/15.
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

    public static void main(String[] args) {
        ArrayList<Integer> a =  new ArrayList<Integer>(Arrays.asList(2, 0, 1));
        arrange(a);
        System.out.println(a);
    }
}
