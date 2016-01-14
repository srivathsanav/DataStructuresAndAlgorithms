package com.interviewbit.assignment.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by srivathsan on 18/12/15.
 */
public class LongestConsequetiveSequence {

    public static int longestConsecutive(List<Integer> num) {
        // if array is empty, return 0
        if (num.size() == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(Arrays.asList(1,2,4,5,3)));
    }
}
