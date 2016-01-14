package com.interviewbit.assignment.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by srivathsan on 04/11/15.
 */
public class DiffK2 {


    public static int diffPossible(final List<Integer> a, int b) {
        if (a.size() <= 1) {
            return  0;
        }
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            numbers.put(a.get(i), i);
        }
        for (int i = 0; i < a.size(); i++) {
            int differenceNeeded = b + a.get(i);
            if (numbers.get(differenceNeeded) != null && numbers.get(differenceNeeded) != i) {
                return 1;
            }
        }
        return  0;
    }

    public static void main(String[] args) {
        System.out.println(diffPossible(Arrays.asList(1, 3, 2) , 0));
    }
}
