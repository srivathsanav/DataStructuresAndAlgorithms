package com.interviewbit.assignment.math;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Excel1 {
    public int titleToNumber(String a) {
        int base = 26;
        char input[] = a.toCharArray();
        int sum = 0;
        int iteration = 0;
        for (int i =  (a.length() -1); i >= 0; i--) {
            if (input[i] >= 'A' && input[i] <= 'Z') {
                int inputVal = (input[i] - 'A') + 1;
                sum = (int) (sum + (inputVal * Math.pow(base,iteration++)));
            } else {
                return 0;
            }
        }
        return sum;
    }
}
