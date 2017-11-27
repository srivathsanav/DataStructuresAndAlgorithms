package com.datastructures;

/**
 * Created by srivathsan on 24/02/17.
 */
public class PatternMatch {

    private static boolean patternMatch(char[] input, char[] pattern) {
        int n = input.length;
        int m = pattern.length;

        for (int i =0 ; i < n - m +1 ; i++) {
            // Compare string
            if (checkEquals(input, i, i + m - 1, pattern, 0, m-1)) {
                System.out.println("Pattern found");
                return true;
            }
        }
        return false;
    }

    private static  boolean checkEquals (char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        if (end1- start1 != end2- start2) {
            return false;
        }
        while (start1 <= end1 && start2 <= end2) {
            if (str1[start1] != (str2[start2])) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(patternMatch("srivathsan".toCharArray(), "sri".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "riv".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "iva".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "vat".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "ath".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "ths".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "hsa".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "san".toCharArray()));
        System.out.println(patternMatch("srivathsan".toCharArray(), "vathsam".toCharArray()));




    }
}
