package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 22/09/15.
 */
public class Remdup {

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

    public static void main(String[] args) {
        //ArrayList<Integer> first =  new ArrayList(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ));

        ArrayList<Integer> first =  new ArrayList(Arrays.asList(0,1,2,3));

        System.out.println(removeDuplicates(first));
    }
}
