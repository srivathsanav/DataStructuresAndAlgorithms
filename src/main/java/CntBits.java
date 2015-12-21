package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 27/10/15.
 */
public class CntBits {

    public static int cntBits(ArrayList<Integer> A) {
        long sum = 0;

        for (int i =0 ; i < 31; i++ ) {
            long oneCount = 0;
            long zeroCount = 0;
            long product = 0;

            for (int k =0; k < A.size() ; k++)  {
                long set =   ((A.get(k) & ( 1 << i)) == 0) ? 0 :1;
                oneCount = oneCount + set;
            }
             zeroCount = A.size() - oneCount;
             product = 2 * oneCount * zeroCount;
            sum = sum + product;
        }

        return (int) (sum % ((Math.pow(10, 9) + 7)));
    }



    public static void main(String[] args) {
        System.out.println(cntBits(new ArrayList<Integer>(Arrays.asList(1, 3, 5))));
    }
}
