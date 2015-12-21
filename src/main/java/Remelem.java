package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 28/10/15.
 */
public class Remelem {
    public static int  removeElement(ArrayList<Integer> a, int b) {
        int count = 0, n = a.size();
        for (int i = 0; i < n; i++) {
            if ( a.get(i).intValue() == b) continue;
            else {

                a.set(count, a.get(i).intValue());
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> first =  new ArrayList(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ));

        ArrayList<Integer> first =  new ArrayList(Arrays.asList(4,1,1,2,1,3));

        System.out.println(removeElement(new ArrayList(1), 0));
    }
}
