package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by srivathsan on 14/12/15.
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if ( k <= 0) {
            return result;
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= n ; i++) {
            numbers.add(i);
        }



        ArrayList<Integer> current = new ArrayList<Integer>();
        Collections.sort(numbers);

        combine(numbers, k, result, current, 0);

        return result;

    }

    private void combine(ArrayList<Integer> numbers, int k , ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int index) {

        if (current.size() == k) {
            ArrayList<Integer> temp = new ArrayList<Integer>(current);
            result.add(temp);
            return ;
        }
        for (int i =index; i < numbers.size(); ) {
            current.add(numbers.get(i));
            combine(numbers, k, result, current, ++i);
            current.remove(current.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
