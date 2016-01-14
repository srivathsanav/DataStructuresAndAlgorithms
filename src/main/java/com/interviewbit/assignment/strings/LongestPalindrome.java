package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 25/10/15.
 */
public class LongestPalindrome {

    public static String longestPalindrome(String a) {
        String longestPal = "";
        int maxLength = Integer.MIN_VALUE;
        for (int i =0; i < a.length(); i++)  {

            for (int j = a.length() -1; j >= i ; j --) {
                if ( j - i > maxLength) {
                    if (isPalindrome(a, i, j)) {
                        int length = j - i ;
                        if (length > maxLength) {
                            longestPal = a.substring(i, j+1);
                            maxLength = length;
                        }
                    }
                }
            }
        }
        return longestPal;
    }

    private static boolean isPalindrome ( String a, int startIndex, int endIndex)  {
        int displacementIndex = startIndex;
        for (int i = startIndex; i <=(startIndex+endIndex)/2 ; i++) {
            if (a.charAt(i) != a.charAt(endIndex -i + displacementIndex)) {
                return  false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
    }
}
