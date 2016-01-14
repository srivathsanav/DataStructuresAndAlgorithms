package com.interviewbit.assignment.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 22/09/15.
 */
public class MergeArray {

    public static void merge(final ArrayList<Integer> a, final ArrayList<Integer> b) {
        int j = 0;
        for (int i = 0; i <= a.size() - 1; i++) {
            for (; j <= b.size() - 1; j++) {
                 if (a.get(i) < b.get(j)) {

                    break;
                } else if (a.get(i) >= b.get(j)) {
                    a.add(i, b.get(j));
                    i++;
                }
            }

        }
        while ( j <= (b.size() -1)) {
            a.add(b.get(j));
            j++;
        }


    }

    public static void main(String[] args) {
        ArrayList<Integer> first =  new ArrayList(Arrays.asList(1, 2));
        ArrayList<Integer> second = new ArrayList(Arrays.asList(-1, 2));

        merge(first, second);
        System.out.println(first);
    }
}
