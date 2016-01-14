package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Palindrome {
    public boolean isPalindrome(int a) {
        if (a < 0) {
            return false;
        }
        int div =1 ;
        while (a/div >= 10) {
            div = div * 10;
        }
        int iteration = 1;
        while (a > 0 && div > 1) {
            int right = a%10;
            int left = a/div;
            if (left != right) {
                return false;
            }
            iteration *= 10;;
            a = a%div;
            a= a / 10;
            div = div / 100;
        }
        return true;
    }
}
