package com.interviewbit.assignment.stacks_queues;

import java.util.Stack;

/**
 * Created by srivathsan on 30/10/15.
 */
public class ReverseString {

    public static String 6(String a) {
        Stack s = new Stack();
        for (int i = 0; i < a.length(); i++) {
            s.push(a.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (s.size() > 0) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("s"));
    }

}
