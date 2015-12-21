package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by srivathsan on 14/12/15.
 */
public class ComninationSum2 {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(candidates == null || candidates.size() == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Collections.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public void combinationSum(ArrayList<Integer> candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        }

        for(int i=j; i<candidates.size();){
            if(target < candidates.get(i))
                return;

            curr.add(candidates.get(i));
            combinationSum(candidates, target - candidates.get(i), ++i, curr, result);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ComninationSum2().combinationSum(new ArrayList<Integer>(Arrays.asList(15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 )) , 33));
    }
}
