package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 18/10/15.
 */
public class Plus1 {

    public static ArrayList<Integer> plusOne(List<Integer> a) {
        ArrayList<Integer> plusone = new ArrayList<Integer>();
        double result = 0;
        int base = 10;
        int index = 0;
        for (int i =a.size()-1; i >=0; i--) {
            result =result + a.get(i) *  Math.pow(10, index);
            //if (result > 0 && a.get(i) != 0)
                index++;
        }
        index--;
        result++;
        while ( result > 0 || index >= 0) {
            if (result > 0) {
                double digit =  result /  Math.pow(10, index);
                if (!(result > 0 && ((int)digit == 0) && plusone.size() ==0)) {
                    if (digit/10 != 1) {
                        plusone.add((int)digit);
                    }   else {
                        plusone.add((int)digit/10);
                        plusone.add((int)digit%10);
                    }

                }
                result = result % (double) Math.pow(10, index);
            } else {
                plusone.add((int)result);
            }
            index --;
        }
        return  plusone;
    }
    public static void main(String[] args) {
        System.out.println(plusOne(Arrays.asList(  0, 3, 7, 6, 4, 0, 5, 5, 5   )));
    }
}
