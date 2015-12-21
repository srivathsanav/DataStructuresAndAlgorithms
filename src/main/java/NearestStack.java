package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by srivathsan on 02/11/15.
 */
public class NearestStack {


    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> first = new Stack<Integer>();
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i =0; i < arr.size(); i++) {
            int currentInput = arr.get(i);
            if (first.size() == 0) {
                returnList.add(-1);
            } else {
                while(first.size() > 0 && first.peek() >= currentInput) {
                    first.pop();
                }
                if (first.size() > 0) {
                    returnList.add(first.peek());
                } else {
                    returnList.add(-1);
                }

            }
            first.push(currentInput);
        }
        return returnList;
    }
    public static void main(String[] args) {

    }
}
