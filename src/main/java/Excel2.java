package com.interviewbit.assignment;

/**
 * Created by srivathsan on 29/10/15.
 */
public class Excel2 {
    public static String convertToTitle(int a) {

        StringBuffer sb = new StringBuffer();
        int baseVal = 'A';
        boolean previousModulo = false;
        while ( a > 0) {
            int modulo = a% 26;
            if (modulo == 0) {
                modulo = modulo + 26;
            }

            int newVal = baseVal + modulo - 1;





            char c =  (char)newVal;
            sb.append(String.valueOf(c));
            a = a/26;
            if (modulo == 26 && a ==1) {
                break;
            }
             previousModulo = (modulo == 26) ? true : false;
            if (previousModulo) {
                a = a - 1;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(650));
    }

}
