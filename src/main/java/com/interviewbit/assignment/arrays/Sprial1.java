package com.interviewbit.assignment.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srivathsan on 15/10/15.
 */
public class Sprial1 {

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (a.size() == 0) {
            return result;
        }
        // Populate result;
        int dir = 0;
        int top = 0; int bottom = a.size()-1;int left = 0; int right = a.get(0).size()-1;

        while (top <= bottom && left <= right) {
            if (dir ==0) {
                for (int i = left; i <= right; i++) {
                    result.add(a.get(top).get(i));
                }
                top++;

                dir = 1;
            } else  if (dir ==1) {
                for (int i = top; i <= bottom; i++) {
                    result.add(a.get(i).get(right));
                }
                right --;

                dir = 2;
            }  else  if (dir ==2) {
                for (int i = right; i >= left; i--) {
                    result.add(a.get(bottom).get(i));
                }
                bottom --;

                dir = 3;
            }  else  if (dir ==3) {
                for (int i = bottom; i >= top; i--) {
                    result.add(a.get(i).get(left));
                }
                left++;

                dir = 0;
            }


        }
        return result;
    }

    public static void main(String[] args) {
        final List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList one = new ArrayList();
        one.add(1);
        one.add(2);


        a.add(one);

        ArrayList two = new ArrayList();
        two.add(3);
        two.add(4);


        a.add(two);

        ArrayList three = new ArrayList();
        three.add(5);
        three.add(6);

        a.add(three);

        ArrayList four = new ArrayList();
        four.add(13);
        four.add(14);
        four.add(15);
        four.add(16);

       // a.add(four);


        System.out.println(spiralOrder(a));
    }
}
