package com.interviewbit.assignment.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srivathsan on 14/01/16.
 */
public class MaxDist {
    public static int maximumGap(final List<Integer> a) {
        HashMap<Integer, List<Integer>> hashMap =  new HashMap<Integer, List<Integer>>();
        for (int i = 0 ; i < a.size(); i++) {
            if (hashMap.get(a.get(i)) == null) {
                List<Integer> ints = new ArrayList<Integer>();
                ints.add(i);
                hashMap.put(a.get(i), ints);

            } else {
                hashMap.get(a.get(i)).add(i);
            }
        }
        Collections.sort(a);
        int maxDifference = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < a.size(); i++) {
            List<Integer> isIndex = hashMap.get(a.get(i));
            int originalIIndex = 0;
            originalIIndex = isIndex.get(0);
            for (int j = i  ; j < a.size(); j++) {
                counter++;
                int originalJIndex = hashMap.get(a.get(j)).get(hashMap.get(a.get(j)).size() -1);
                if (originalIIndex <= originalJIndex) {
                    int currentDifference = originalJIndex - originalIIndex;
                    if (maxDifference < currentDifference) {
                        maxDifference = currentDifference;
                    }
                }
            }
        }
        return maxDifference;
    }
}
