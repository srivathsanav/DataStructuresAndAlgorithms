package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class DecBin {
    public String findDigitsInBinary(int a) {
        StringBuffer sb = new StringBuffer();
        if (a == 0)  {
            return "0";
        } else if (a ==1) {
            return "1";
        }
        while (a > 0) {
            if (a % 2 == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            a = a/2;
        }
        StringBuffer newStringBuffer = new StringBuffer();
        for (int i = sb.length() -1 ; i >= 0; i--) {
            newStringBuffer.append(sb.charAt(i));
        }
        return newStringBuffer.toString();
    }
}
