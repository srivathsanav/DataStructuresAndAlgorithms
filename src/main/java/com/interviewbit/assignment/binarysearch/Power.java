package com.interviewbit.assignment.binarysearch;

/**
 * Created by srivathsan on 08/10/15.
 */
public class Power {

    public static int pow(int x, int n, int d) {
        long result = 0;
        if (n == 0) {
            if (x != 0)
                return 1 ;
            else
                return 0;
        }
        if (n%2 == 0) {
            long k = pow(x, n/2, d) % d;
            result =  (k * k) ;
        } else {
            result =  (x%d * (pow(x, n-1, d) % d));

        }
        if (result < 0 ) {
            result = (result + d) % d ;
        }
        return (int)result;
    }


    public static int pow1(int x, int n, int d) {
        long result = 1;
        long a = x;
       while ( n > 0) {
           if ( n % 2 == 1) {
               result = (result  * a );
               result = result % d;
           }

           a =  ( a * a ) ;
           a = a % d;
           n = n/2;
       }
        result = (result + d) % d;

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(pow1(71045970, 41535484, 64735492));
       // System.out.println(pow1(2, 3, 3));


    }
}
