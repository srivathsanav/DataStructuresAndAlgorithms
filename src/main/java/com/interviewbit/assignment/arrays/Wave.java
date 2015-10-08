package com.interviewbit.assignment.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by srivathsan on 08/10/15.
 */

public class Wave {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i =1 ; i< a.size(); i+=2) {
            int temp = a.get(i-1);
            a.set(i-1,  a.get(i)) ;
            a.set(i,  temp) ;
        }
        return a;
    }
}
