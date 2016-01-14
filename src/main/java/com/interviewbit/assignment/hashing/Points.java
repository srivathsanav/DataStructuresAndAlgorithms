package com.interviewbit.assignment.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by srivathsan on 15/11/15.
 */
public class Points {

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {

        if (a.size() == 0 || b.size() == 0) {
            return  0;
        } else if (a.size() == 1 || b.size() == 1) {
            return  1;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i =0; i < a.size(); i++) {
            int dup =0;
            HashMap<Double,Integer> slopeMap = new HashMap<Double, Integer>();

            for (int j = i+1 ; j < a.size(); j++) {
                int a1 = a.get(i);
                int a2 = a.get(j);
                int b1 = b.get(i);
                int b2 = b.get(j);
                if (a1 == a2 && b1 == b2) {
                    dup++;
                    continue;
                }
                double diff1 = 1.0 * (a2- a1);
                double diff2 = 1.0* ( b2 - b1);
                if (diff1 == 0 ) {
                    maxValue = populateMap(slopeMap, Integer.MIN_VALUE, maxValue, i, j );
                } else {
                    double slope = diff2/diff1;
                    if (slope == -0.0) {
                        slope = Math.abs(slope);
                    }
                    maxValue = populateMap(slopeMap, slope, maxValue, i , j);
                }
            }
            for (Integer count : slopeMap.values()) {

                maxValue = Math.max(maxValue, count.intValue() + dup);

            }

        }
         		return maxValue > 0 ? maxValue : a.size();
    }

    


    private Integer populateMap(HashMap<Double,Integer> slopeMap, double value, int maxValue, int i , int j) {
        if (slopeMap.get(value) != null) {
            int val = slopeMap.get(value) +1 ;

            if (val > maxValue) {
                maxValue = val;
            }
            slopeMap.put(value, val);
        } else {
            int val = 2 ;
            if (val > maxValue) {
                maxValue = val;
            }
            slopeMap.put(value, val);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String x = "14 -2 -17 -3 2 3 -13 -5 -18 6 9 -10 15 5 2 11 -3 18 -7 -1 -10 -13 14 -6 -2 13 -18 -14 -7 -1 12 -19 1 -13 -9 2 -16 -6 -4 -3 11 2 -4 -2 -16 -11 17 5 5 -13 8 18 -16 -15 -8 12 5 5 4 14 16 2 14 8 -12 4 13 -20 2 -1 -14 -1 -9 -16 20 20 -5 -9 -19 -2 -16 0 -19 1 3 -4 3 -1 1 -20 -18 -2 19 -9 11 2 -16 10 10 -12 12 4 -5 12 -1 -3 -5 2 -17 3 -20 4 18 -1 -15 10 -3 19 -5 -17 17 14 14 7 0 17 0 5 3 -9 10 -13 13 6 10 18 15 1 2 2 19 4 -14 6 -17 6 4 -3 6 7 1 18 12 18";
         String input[] = x.split(" ");
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        for (int i = 0; i < input.length; i++) {
            a.add(Integer.parseInt(input[i]));
            b.add(Integer.parseInt(input[++i]));
        }
        System.out.println(new Points().maxPoints(a, b));

       // System.out.println(new Points().maxPoints(new ArrayList(Arrays.asList(1,1)), new ArrayList(Arrays.asList(1,1))));
    }
}
