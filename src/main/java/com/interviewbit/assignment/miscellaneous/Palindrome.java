package com.datastructures;

/**
 * Created by srivathsan on 21/02/17.
 */
public class Palindrome {

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return true;
        }

        for (int i =0,  j = input.length() -1; i < input.length()/2 ; ) {
            if (input.charAt(i) == ' ') {
                i++;
            } else if (input.charAt(j) == ' ') {
                j--;
            } else if (Character.toUpperCase(input.charAt(i)) != Character.toUpperCase(input.charAt(j))) {
                return false;
            } else {
                i++; j--;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A Santa dog lived as a devil God at NASA"));
    }
}
