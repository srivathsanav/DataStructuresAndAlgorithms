package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 23/10/15.
 */
public class IntToRoman {

    public static String intToRoman(int a) {
        StringBuffer sb = new StringBuffer();

        while (a > 0) {
            if (a >= 1000) {
                sb.append("M");
                a = a - 1000;
            } else if (a < 1000 && a >= 900) {
                sb.append("CM");
                a = a - 900;
            } else  if (a >= 500) {
                sb.append("D");
                a = a - 500;
            }  else  if (a < 500 && a >= 400)  {
                sb.append("CD");
                a = a - 400;
            } else  if (a >= 100) {
                sb.append("C");
                a = a - 100;
            }  else  if (a < 100 && a >= 90) {
                sb.append("XC");
                a = a - 90;
            } else  if (a >= 50) {
                sb.append("L");
                a = a - 50;
            } else  if (a < 50 && a >= 40) {
                sb.append("XL");
                a = a - 40;
            } else  if (a >= 10) {
                sb.append("X");
                a = a - 10;
            } else  if (a < 10 && a>= 9) {
                sb.append("IX");
                a = a - 9;
            } else  if (a >= 5) {
                sb.append("V");
                a = a - 5;
            }  else  if (a < 5 && a >= 4) {
                sb.append("IV");
                a = a - 4;
            } else  if (a >= 1) {
                sb.append("I");
                a = a - 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(409));
    }
}
