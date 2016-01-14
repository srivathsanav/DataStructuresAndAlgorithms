package com.interviewbit.assignment.stacks_queues;

import java.util.Stack;

/**
 * Created by srivathsan on 07/10/15.
 */
public class Parenthesis {

    public static int isValid(String a) {
        Stack<Character> input = new Stack<Character>();
        for (int i = 0 ; i < a.length(); i++) {
            if ((a.charAt(i) == '(')  || (a.charAt(i) == '{') || (a.charAt(i) == ('['))) {
                input.push(a.charAt(i));
            } else {
                if(input.size() > 0 ) {
                    Character currentChar = input.pop();
                    if (a.charAt(i) == ']' && currentChar != '[')
                        return 0;
                    else if (a.charAt(i) == '}' && currentChar != '{')
                        return 0;
                    else if (a.charAt(i) == ')' && currentChar != '(')
                        return 0;
                } else {
                    return  0;
                }

            }
        }
        if (input.size() == 0)
            return  1;
        else
            return  0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{"));
    }
}
