package com.interviewbit.assignment;

/**
 * Created by srivathsan on 25/10/15.
 */
public class NumoFBits {

    public static int numSetBits(long a) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int set =   ((a & ( 1 << i)) == 0) ? 0 :1;
            count = count + set;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSetBits(3));
    }

}
