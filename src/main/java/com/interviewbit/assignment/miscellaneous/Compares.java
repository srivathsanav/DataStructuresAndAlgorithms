package com.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by srivathsan on 06/02/17.
 */
public class Compares {

    public static void main(String[] args) {
        System.out.println(maxMirror(new int[]{10, 1, 2, 3, 3, 2, 1}));


    }

    public static List<Integer> maxMirror(int[] nums) {
        int max = 0;
        List<Integer> maxList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            List<Integer> currentMaxList = new ArrayList<>();
            int index = 0;
            for(int j = nums.length - 1; j >= 0  &&  j > (i+count); j--) {
                if(nums[i + count] == nums[j]) {
                    currentMaxList.add(nums[j]);
                    count++;
                } else {
                   continue;
                }
            }

            max = Math.max(max, count);
            if (max == count) {
               maxList = currentMaxList;
            }
        }
        return maxList;
    }


}
