package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 26/10/15.
 */
public class Single2 {

    public  static int singleNumber(final List<Integer> a) {
        int odd = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int k =0 ; k < a.size(); k++) {
                int set =   ((a.get(k) & ( 1 << i)) == 0) ? 0 :1;
                count = count + set;

            }
            if (count % 3 != 0) {
                odd = 1 << i | odd;
            } else {
                odd &= ~(1 << i);

            }
        }
        return odd;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1,4,4, 1000)));
    }
}
