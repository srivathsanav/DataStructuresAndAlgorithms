package com.interviewbit.assignment.binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class FindMin {

        public static int findMin(final List<Integer> a) {
            int high = a.size() - 1;
            int low = 0;
            int N = a.size();
            while (low <= high) {
                int mid = high - ((high - low))/2;
                int prev = (mid - 1 + N) % N;
                int next =  (mid + 1)% N;
                if (a.get(low) <= a.get(high)) {
                    return a.get(low);
                } else if (a.get(mid) < a.get(prev)  && a.get(mid) < a.get(next)) {
                    return a.get(mid);
                } else if (a.get(mid) < a.get(high)) {
                    high = mid - 1;
                } else if (a.get(low) < a.get(mid)) {
                    low = mid +1;
                }
            }
            return -1;
        }

    public static void main( String[] args )
    {
        List<Integer> arrays = Arrays.asList(1);
        System.out.println(findMin(arrays));

    }
}
