package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 16/10/15.
 */
public class Rotate2D {

    public static ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> A) {
        int n;


        n = A.size();



        int layers = n;
        int row1, col1, row2, col2;
        int num;
        int temp;
        int first, last;

        for (int layer = 0; layer < layers / 2; layer++) {

            first = layer;
            last = n - layer - 1;

            for (int i = first; i < last; i++) {

                int offset = i - layer;

                int top = A.get(first).get(i);

                A.get(first).set(i, A.get(last - offset).get(first));

                A.get(last - offset).set(first, A.get(last).get(last - offset));

                A.get(last).set(last - offset, A.get(i).get(last));

                A.get(i).set(last, top);
            }

        }
        return A;
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


        rotate(a);

        System.out.println(a);


    }
}
