package com.interviewbit.assignment.dynamicprogramming;

/**
 * Created by srivathsan on 25/01/16.
 */
public class Jump1 {

    public boolean canJump(int[] A) {
        int next = A.length - 1;
        for (int i=A.length-2; i>=0; --i) {
            if (A[i] >= (next - i)) {
                next = i;
            }
        }
        return (next == 0);
    }

    public static void main(String[] args) {
       System.out.println(new Jump1().canJump(new int[] {2,3,1,1,4}));
    }
}
