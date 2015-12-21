package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by srivathsan on 14/12/15.
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> current = new ArrayList<Integer> ();
        Collections.sort(S);

        generateSubsets(S, 0, current, result);

        Collections.sort(result, new Comparator<ArrayList<Integer>>() {

            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        return result;
    }




    void generateSubsets(ArrayList<Integer> S, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (index >= S.size()) {
            if (!result.contains(new ArrayList<Integer>(current)))
                result.add(new ArrayList<Integer>(current));
            return;
        }
        // Ignore the current index.
        generateSubsets(S, index + 1, current, result);

        // Include the current index.
        current.add(S.get(index));
        generateSubsets(S, index + 1, current, result);
        current.remove(current.size()-1);
    }


    public static void main(String[] args) {
       // System.out.println(new Subsets().subsets(new ArrayList<Integer>(Arrays.asList(1,2, 3))));

        System.out.println(new Subsets().subsets(new ArrayList<Integer>(Arrays.asList(1,2, 2))));

    }

}
