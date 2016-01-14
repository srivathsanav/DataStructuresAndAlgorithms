package com.interviewbit.assignment.stacks_queues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by srivathsan on 07/10/15.
 */
public class ReversePolishNotation {

    public static int evalRPN(List<String> a) {
        Stack<String> stack = new Stack<String>();
        int result = 0;

        for (int i = 0 ; i < a.size();i++) {
            String currentInput = a.get(i);
            if (currentInput.equals("*") || currentInput.equals("+") || currentInput.equals("/") || currentInput.equals("-")) {
                if (stack.size() == 0) {
                    return  0;
                }
                int value2 = Integer.valueOf(stack.pop());
                if (stack.size() == 0) {
                    return  0;
                }
                int value1 = Integer.valueOf(stack.pop());
                if (currentInput.equals("+")) {
                    result = value1 + value2;

                } else  if (currentInput.equals("-")) {
                    result = value1 - value2;
                } else  if (currentInput.equals("*")) {
                    result = value1 * value2;
                } else  if (currentInput.equals("/")) {
                    result = value1 / value2;
                }
                stack.push(result+"");
            } else {
                stack.push(currentInput);
            }
        }
        return  Integer.valueOf(stack.pop());
    }


    public static void main(String[] args) {
        System.out.println(evalRPN(Arrays.asList( "5")));
    }
}
