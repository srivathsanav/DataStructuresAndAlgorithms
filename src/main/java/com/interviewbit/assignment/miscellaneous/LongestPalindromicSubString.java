package com.datastructures;

/**
 * Created by srivathsan on 05/03/17.
 */
public class LongestPalindromicSubString {

    private static void longestPalindromicSubString(String  input) {

        for (int i = 0 ; i < input.length(); i++) {
            for (int j = i; j <= input.length(); j++) {
                        char[] temp = new char[j-i];
                        int count = 0;
                        for (int k = i; k <j; k++) {
                            temp[count++] = input.charAt(k);
                        }
                        System.out.println(temp);

            }
        }
    }

    public static void main(String[] args) {
        longestPalindromicSubString("banana");
    }
}
