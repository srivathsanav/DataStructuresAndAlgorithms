package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 26/10/15.
 */
public class BitArraySingle {

    public static int singleNumber(final List<Integer> a) {
        int value = 0;
        for (int i =0; i < a.size(); i++) {
            value = value ^ a.get(i);
        }
        return  value;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(1, 2, 2, 3, 1, 3, Integer.MIN_VALUE)));
    }
}
