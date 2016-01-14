package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 14/01/16.
 */
public class LengthLast {
    public static int lengthOfLastWord(final String a) {
        char[] myArr = a.toCharArray();
        int length = 0;
        for (int i = myArr.length - 1; i >= 0; i--) {
            if (length >= 1 && myArr[i] == ' ') {
                return length;
            }
            if (myArr[i] != ' ') {
                length++;
            }
        }
        return length;
    }
}
