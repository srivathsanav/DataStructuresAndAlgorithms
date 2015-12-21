package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 17/10/15.
 */
public class MaxGap {

    public static int maximumGap(final List<Integer> A) {

        if (A == null || A.size() < 2)
            return 0;

        int max = A.get(0);
        int min = A.get(0);
        int n = A.size();

        for (int i = 0; i < n; i++) {
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
        }

        int buckets = n - 1;
        int gap = (max - min - 1) / (n - 1) + 1;
        int minArray[] = new int[buckets];
        int maxArray[] = new int[buckets];
        int bucket;

        Arrays.fill(minArray, Integer.MAX_VALUE);
        Arrays.fill(maxArray, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int num = A.get(i);

            if (num == max || num == min)
                continue;

            bucket = (num - min) / gap;

            minArray[bucket] = Math.min(minArray[bucket], num);
            maxArray[bucket] = Math.max(maxArray[bucket], num);
        }

        int res = 0;
        int maxVal = max;

        for (int i = 0; i < buckets; i++) {
            max = minArray[i];

            if (max != Integer.MAX_VALUE)
                res = Math.max(res, max - min);

            if (maxArray[i] != Integer.MIN_VALUE) {
                min = maxArray[i];
            }
        }

        res = Math.max(res, maxVal - min);

        return res;

    }

    /*public static int maximumGap(final List<Integer> a) {
        if (a.size() < 2)
            return  0;
        int maxDiff = Integer.MIN_VALUE;
        Collections.sort(a);
        for (int i = 0 ; i < a.size(); i++) {
            if ( (i +1) < a.size()) {
                int diff = a.get(i+1) - a.get(i);
                if (maxDiff < diff) {
                    maxDiff = diff;
                }
            }
        }
        return  maxDiff;
     }*/
    public static void main(String[] args) {
        System.out.println(maximumGap(Arrays.asList(1, 10,200, 5,20,21,31,45, 100)));
    }
}
