package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Revint {
    public static int reverse(int a) {
        boolean negative = false;
        if (a < 0) {
            negative = true;
            a = Math.abs(a);
        }
        int reversed = 0;
        int power = 0;
        int base = 10;
        int input = a;
        while (input/10 > 0) {
            power++;
            input = input/10;
        }
        while ( a > 0) {
            int modulo = a%10;
            reversed = (int) (reversed + (modulo * Math.pow(base, power)));

            if (reversed >= Integer.MAX_VALUE || reversed <= Integer.MIN_VALUE ) {
                return 0;
            }
            power--;
            a = a /10;
        }
        if (negative) {
            reversed = 0 - reversed;
        }
        return reversed;
    }
}
