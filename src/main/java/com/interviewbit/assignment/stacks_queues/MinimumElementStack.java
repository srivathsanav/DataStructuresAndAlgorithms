package com.interviewbit.assignment.stacks_queues;

import java.util.Stack;

/**
 * Created by srivathsan on 02/11/15.
 */
public class MinimumElementStack {


    Stack<Integer> stack = new Stack<Integer>();

    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        if (minStack.empty()) {
            minStack.push(x);
        } else if (!minStack.empty() && x < getMin()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.size() != 0) {
             int value = stack.pop();
            if (value == getMin()) {
                minStack.pop();
            }
        }

    }

    public int top() {
        if (stack.size() == 0) {
            return -1;
        } else {
            return stack.peek();
        }
    }

    public int getMin() {
        if (minStack.empty()) {
            return -1;
        }
            return minStack.peek();

    }


    public static void main(String[] args) {


        String s = "P 644643544 g t t t p P 723943208 p P 909204 g t g t P 481523691 p P 465865082 t P 243519307 p t p P 844871295 g";
        String spilt[] = s.split(" ");
        MinimumElementStack minStack = new MinimumElementStack();

        for (int i =0; i < spilt.length; i++) {
            if (spilt[i].equals("P") ) {
                minStack.push(Integer.parseInt(spilt[i+1]));
            } else if (spilt[i].equals("g")) {
                System.out.println(minStack.getMin());
            } else if (spilt[i].equals("p")) {
                minStack.pop();
            } else if (spilt[i].equals("t")) {
                System.out.println(minStack.top());
            }
        }


    }
}

