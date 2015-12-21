package com.interviewbit.assignment;

import java.util.*;

/**
 * Created by srivathsan on 18/10/15.
 */
public class MaximumGap {

    // DO NOT MODIFY THE LIST
    public static int maximumGap(final List<Integer> A) {
        int n = A.size();
        int minLeft[] = new int[n];
        int maxRight[] = new int[n];

        minLeft[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], A.get(i));
        }

        maxRight[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], A.get(i));
        }

        int i = 0, j = n - 1;
        int max = -1;

        for (j = n - 1; j >= 0; j--) {
            int num = maxRight[j];
            i = minIndex(minLeft, num);
            max = Math.max(j - i, max);
        }


        return max;
    }


    public static int minIndex(int [] minLeft, int num) {

        int lo, hi, mid;
        int index = -1;

        lo = 0;
        hi = minLeft.length;

        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);

            int minNum = minLeft[mid];

            if (num < minNum) {
                lo = mid + 1;
            } else {
                index = mid;
                hi = mid - 1;
            }
        }

        return index;

    }


    public static int maximumGap1(final List<Integer> a) {
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



    public static void main(String[] args) {
        System.out.println(maximumGap(Arrays.asList( 3, 5, 4,2)));
    }
}
