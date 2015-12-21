package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by srivathsan on 28/10/15.
 */
public class ThreeSumZero {

    private static boolean alreadyAvailable (int a, int b , int c, ArrayList<ArrayList<Integer>> list) {
        for (int i =0; i < list.size(); i++) {
            if (list.get(i).get(0).intValue() == a) {
                if (list.get(i).get(1).intValue() == b) {
                    if (list.get(i).get(2).intValue() == c) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }  else if (list.get(i).get(0) > a) {
                return false;
            }
        }
        return  false;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        long target =0;
        for ( int k =0; k < a.size(); k ++) {
            if (k != 0 && a.get(k).intValue() != a.get(k-1).intValue()) {
                target = 0 - a.get(k);
                int j = a.size() - 1;
                for (int i = k + 1; i < a.size(); i++) {
                    for (; j > i; j--) {
                        long sum = (long) a.get(i).intValue() + a.get(j).intValue();

                        if (sum == target) {
                                ArrayList<Integer> result = new ArrayList<Integer>();
                                result.add(a.get(k));
                                result.add(a.get(i).intValue());
                                result.add(a.get(j).intValue());
                                test.add(result);
                                int prev = a.get(i).intValue();
                                while ( i < j && prev == a.get(i)) {
                                        i++;

                                }

                        } else if (sum < target) {
                            break;
                        }
                    }
                }
            }
        }
        return test;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new ArrayList<Integer>(Arrays.asList(-1, 0, 1, 2, -1, -4))));
    }
}
