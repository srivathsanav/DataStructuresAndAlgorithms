package com.interviewbit.assignment.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 21/09/15.
 */
public class IntersectArray {
    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        int j = 0;
        ArrayList<Integer> mergedArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= a.size() - 1; i++) {
            for (; j <= b.size() - 1; j++) {
                if (a.get(i).intValue() == b.get(j).intValue()) {
                    mergedArrayList.add(a.get(i));
                    j++; break;
                } else if (a.get(i) < b.get(j)) {
                    break;
                }
            }

        }
        return mergedArrayList;

    }

    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(10000000);
        List<Integer> second = Arrays.asList(10000000);
        System.out.println(intersect(first, second));
    }
}
