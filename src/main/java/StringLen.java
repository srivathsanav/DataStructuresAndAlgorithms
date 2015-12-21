package com.interviewbit.assignment;

/**
 * Created by srivathsan on 14/11/15.
 */
public class StringLen {

    private int length (String a) {
        if (a.length() == 1) {
            return 1;
        }
        return  1 + length(a.substring(0, a.length() -1));
    }

    public static void main(String[] args) {
        System.out.println(new StringLen().length("java"));
    }
}
