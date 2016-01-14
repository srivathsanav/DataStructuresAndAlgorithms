package com.interviewbit.assignment.two_pointers;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Remdup2 {
    public static int removeDuplicates(ArrayList<Integer> A) {
        int count = 0, n = A.size();
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && A.get(i).intValue() == A.get(i+2).intValue()) continue;
            else {

                A.set(count, A.get(i).intValue());
                count++;
            }
        }
        return count;
    }
}
