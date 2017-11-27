package com.interviewbit.assignment.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srivathsan on 25/01/16.
 */
public class Stairs {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int climbStairs(int a) {
        if ( a <= 1) {
            return 1;
        }
        int steps;
        if (!map.containsKey(a)) {
            steps = climbStairs(a-1) + climbStairs(a-2);
            map.put(a, steps);
        } else {
            return map.get(a);
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Stairs().climbStairs(4));
    }
}
