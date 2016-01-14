package com.interviewbit.assignment.bitmanipulation;

/**
 * Created by srivathsan on 25/10/15.
 */
public class ReverseBits {

    public static long reverse(long a) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            int set =   ((a & ( 1 << i)) == 0) ? 0 :1;
            sb.append(set);
        }
        int base = 2;
        int index = 0;
        long value = 0;
        for (int i =sb.length() -1 ; i >=0; i--)  {
             value = value + (sb.charAt(i) - '0') *(long) Math.pow(base, index);
            index++;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(reverse(10));
    }
}
