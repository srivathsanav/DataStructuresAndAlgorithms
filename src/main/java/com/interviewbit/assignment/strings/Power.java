package com.interviewbit.assignment.strings;

import java.math.BigInteger;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Power {
    public static int power(String a) {

        if (Double.valueOf(a) <= 1) {
            return 0;
        }
        BigInteger input = new BigInteger(a);
        while (input.doubleValue() > 1) {
            if ((input.mod( BigInteger.valueOf(2)) != BigInteger.valueOf(0)))  {
                return  0;
            }
            input = input.divide(BigInteger.valueOf(2));
        }
        return  1;
    }
}
