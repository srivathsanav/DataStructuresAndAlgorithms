package com.interviewbit.assignment.math;

import java.math.BigInteger;

/**
 * Created by srivathsan on 24/10/15.
 */
public class PowerOf2 {

    public static int power1(String a) {
        double input = Double.valueOf(a);
        if (input <= 1) {
            return 0;
        }
        double number = log(input, 2);
        if (number == (int)number) {
            return  1;
        }
        return  0;

    }

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


    private static double log(double x, int base ) {
        {
            return  (Math.log(x) / (Math.log(base)));
        }
    }
    public static void main(String[] args) {

        System.out.println(power("453111137367687706473027701228"));
    }

}
