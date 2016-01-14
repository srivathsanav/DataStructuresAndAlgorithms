package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 15/10/15.
 */
public class Diagonal {

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList first;
        if (a.size() == 0) {
            return  result;
        }

        for (int i = 0 ; i < a.size(); i++) {
            first = new ArrayList();
            int col = i; int row = 0;
            for (int j = col; j >= 0; j --) {
                if (row == a.size() ) {
                    break;
                }
                first.add(a.get(row).get(j));
                row++;
            }
            result.add(first);

        }

        for (int k = 1 ; k < a.size(); k++) {
            first = new ArrayList();
            int col = a.size() -1; int row = k;
            for (int j = col; j >= 0; j --) {
                if (row == a.size() ) {
                    break;
                }
                first.add(a.get(row).get(j));
                row++;
            }
            result.add(first);

        }

        return  result;
    }

    public static void main(String[] args) {
        final ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList one = new ArrayList();
        one.add(1);
        one.add(2);
        one.add(3);
        one.add(4);

        a.add(one);

        ArrayList two = new ArrayList();
        two.add(5);
        two.add(6);
        two.add(7);
        two.add(8);

        a.add(two);

        ArrayList three = new ArrayList();
        three.add(9);
        three.add(10);
        three.add(11);
        three.add(12);

        a.add(three);


        ArrayList four = new ArrayList();
        four.add(13);
        four.add(14);
        four.add(15);
        four.add(16);

        a.add(four);

        System.out.println(diagonal(a));
    }
}
