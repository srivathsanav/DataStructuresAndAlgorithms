package com.interviewbit.assignment.hashing;

import java.util.HashMap;

/**
 * Created by srivathsan on 13/10/15.
 */
public class Colorful {

    public static int colorful(int a) {
        if ( a < 0) {
            return  0;
        }
        HashMap<Integer, Integer> mappedNumber = new HashMap<Integer, Integer>();
        String number = String.valueOf(a);
        for (int i = 1 ; i <= number.length() ; i++) {
            for (int j = 0; j <= number.length(); j++) {
                if ((j +i) > number.length()) {
                    break;
                }

                String subSequence = number.substring(j, j+i);
                int product = 1;
                if (subSequence.length() > 1) {
                    int value = Integer.parseInt(subSequence);
                    int count = 1;
                    while (value > 0) {
                        product = product * (value % 10);
                        value = value / (10*count);
                    }
                } else {
                    product = Integer.parseInt(subSequence);
                }
                if (mappedNumber.get(product) != null) {
                    return 0;
                }
                mappedNumber.put(product,product);
            }
        }
        return  1;
    }



    public static void main(String[] args) {
        System.out.println(colorful(-23));

    }
}
