package com.interviewbit.assignment.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by srivathsan on 08/10/15.
 */

public class Largestnum {
    // DO NOT MODIFY THE LIST
    public static String largestNumber(final List<Integer> a) {
        StringBuffer strBuf = new StringBuffer();

        Collections.sort(a, new MyComparator());
        for (int n : a) {
            if (n == 0 && strBuf.length() != 0)
                continue;
            strBuf.append(n);
        }

        return strBuf.toString();

    }

    static class MyComparator implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            String firstString = o1 + "" + o2;
            String secondString = o2 + "" + o1;
            return secondString.compareTo(firstString);
        }

    }
}
