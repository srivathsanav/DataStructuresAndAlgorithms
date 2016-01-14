package com.interviewbit.assignment.stacks_queues;

import java.util.Stack;

/**
 * Created by srivathsan on 02/11/15.
 */
public class Braces {

    public static int braces(String a) {
        Stack<Character> braces = new Stack<Character>();

        for (int i =0 ; i < a.length(); i++) {
            if (a.charAt(i) == ')') {
                int count =0;
                while (braces.size() > 0) {
                    if (braces.pop() == '(') {
                        if (count <= 1) {
                            return 1;
                        } else {
                            break;
                        }
                    } else {
                        count++;
                    }
                }
            } else {
                braces.push(a.charAt(i));

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(braces("(A)"));
    }
}
