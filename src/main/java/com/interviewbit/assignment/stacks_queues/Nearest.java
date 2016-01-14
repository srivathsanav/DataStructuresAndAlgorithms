package com.interviewbit.assignment.stacks_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by srivathsan on 07/10/15.
 */
public class Nearest {

    public static ArrayList<Integer> prevSmaller(List<Integer> arr) {
        Stack<Integer> first = new Stack<Integer>();
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i =arr.size()-1; i >= 0; i--) {
            int currentInput = arr.get(i);
            if (first.size() == 0) {
                returnList.add(0,-1);
            } else {
                while(first.size() > 0 && first.peek() <= currentInput) {
                    first.pop();
                }
                if (first.size() > 0) {
                    returnList.add(0,first.peek());
                } else {
                    returnList.add(0,-1);
                }

            }
            first.push(currentInput);
        }
        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(prevSmaller(Arrays.asList(3,2,1)));

    }
}
