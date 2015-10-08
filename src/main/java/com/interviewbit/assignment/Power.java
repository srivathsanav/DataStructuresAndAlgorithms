package com.interviewbit.assignment;

/**
 * Created by srivathsan on 08/10/15.
 */
public class Power {

    public static long Mod(int a, int b, int c) {
        long result = 0;
        if (b == 0) {
            if (a != 0)
                return 1 ;
            else
                return 0;
        }
        if (b%2 == 0) {
            long k = Mod(a, b/2, c);
            result =  (k * k) % c ;
        } else {
            result =  (a%c * Mod(a, b-1, c)) % c;

        }
        if (result < 0 ) {
            result = (result + c) % c ;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(Mod(71045970, 41535484, 64735492));

        System.out.println((Math.pow(-1,1)) % 20);
    }
}
