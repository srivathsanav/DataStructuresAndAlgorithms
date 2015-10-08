package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 22/09/15.
 */
public class Remdup {

    public static int removeDuplicates(ArrayList<Integer> a) {
        int count = 0;
        for (int i =0 ; i < a.size(); i++) {
            if ( (i == a.size() -1) || a.get(i).intValue() != a.get(i + 1).intValue()) {
                a.set(count, a.get(i));
                count++;
            } else {
                a.remove(i);
                i--;
            }

        }
        System.out.println(a);

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> first =  new ArrayList(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ));

        System.out.println(removeDuplicates(first));
    }
}
