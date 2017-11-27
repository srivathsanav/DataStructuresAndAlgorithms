package com.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 23/03/17.
 */
public class Subsets {

    private static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> input, int index) {
        ArrayList<ArrayList<Integer>> allSubsets=  new ArrayList<>();
        if (input.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets =  getAllSubsets(input, index + 1);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            int item = input.get(index);
            for (ArrayList subsets : allSubsets) {
                ArrayList<Integer> newSubsets = new ArrayList<>();
                newSubsets.addAll(subsets);
                newSubsets.add(item);
                moreSubsets.add(newSubsets);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;

    }

    public static void main(String[] args) {
        System.out.println(getAllSubsets(new ArrayList<>(Arrays.asList(1, 2, 3)), 0));
    }
}
