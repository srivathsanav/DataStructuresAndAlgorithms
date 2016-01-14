package com.interviewbit.assignment.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srivathsan on 05/11/15.
 */
public class TwoSum {

    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        if (a.size() <= 1) {
            return new ArrayList<Integer>();
        }

        int target = b;
        HashMap<Integer,List<Integer>> val = new HashMap<Integer, List<Integer>>();
        for (int i =0 ; i < a.size(); i++) {
            List<Integer> result = null;
            if (val.get(a.get(i)) == null) {
                result = new ArrayList<Integer>();
                result.add(i+1);
                val.put(a.get(i), result);

            } else {
                result = val.get(a.get(i));
                result.add(i+1);
            }
        }


        int minVal = Integer.MAX_VALUE;

        int value1 = 0;
        int value2 = 0;
        boolean found = false;

        for (int i =0 ; i < a.size(); i++) {
            int currentVal = target - a.get(i);
            List<Integer> result = val.get(currentVal);
            if (result != null) {
                for (Integer value : result) {
                    if (val.get(currentVal) != null && i < value - 1) {
                        found = true;
                        if (minVal > value) {
                            minVal = value;
                            value1 = i + 1;
                            value2 = minVal;
                        }
                    }
                }
            }

        }


        if (!found) {
            return new ArrayList<Integer>();
        } else {
            ArrayList<Integer> returnList = new ArrayList<Integer>();
            returnList.add(value1);
            returnList.add(value2);
            return  returnList;
        }
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new ArrayList<Integer>(Arrays.asList( 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8)), -3));
    }

}
