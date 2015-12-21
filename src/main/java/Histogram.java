package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by srivathsan on 02/11/15.
 */
public class Histogram {


    public static int largestRectangleArea1(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < a.size()) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || a.get(i) >= a.get(stack.peek())) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = a.get(p);
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = a.get(p);
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static int largestRectangleArea(ArrayList<Integer> a) {
       Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
       for (int i =0; i < a.size(); i++) {
           if (stack.size() == 0) {
               stack.push(a.get(i));
           } else if (stack.peek() <= a.get(i)) {
               stack.push(a.get(i));
           } else if (stack.peek() > a.get(i)) {
               int rightIndex = i;
               int leftIndex = i;
               int item = 0;
               while (!stack.empty() && stack.peek() > a.get(i)) {
                   item = stack.pop();
                   if (leftIndex > 0)
                     leftIndex--;
               }
               int count = 0;
               while (rightIndex -leftIndex > count) {
                   stack.push(a.get(i));
                   count ++;
               }
               area = (rightIndex - leftIndex) * item;
               if (maxArea < area) {
                   maxArea = area;
               }
               stack.push(a.get(i));

           }
       }
        int rightIdex = 0;
        int leftIndex = 1;
        while (!stack.empty()) {
            int value1 = stack.pop();
            if (!stack.empty()) {
                leftIndex++;
                int value2 = stack.peek();
                area = Math.min(value1, value2) * (leftIndex - rightIdex);
                if (maxArea < area) {
                    maxArea = area;
                }
            } else {
                area = value1 * 1;
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return  maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea1(new ArrayList<Integer>(Arrays.asList(6, 2, 5, 4, 5, 1, 6))));
    }
}
