package com.interviewbit.assignment;

import java.util.ArrayList;

/**
 * Created by srivathsan on 23/09/15.
 */
public class SortColor {

    public static void sortColors(ArrayList<Integer> a) {
        int  zeroIndex = -1;
        int secondIndex = -1;
        int firstIndex = -1;
        for (int i = 0; i < a.size(); i++) {
            if (i != a.size() -1  && a.get(i).intValue() > a.get(i+1).intValue()) {
                if (a.get(i) == 2 && secondIndex != -1) {
                    a.set(secondIndex, a.get(i));
                } else if (a.get(i) == 2){
                    secondIndex = i;
                }

                 if (a.get(i) ==1 && firstIndex != -1) {
                    a.set(firstIndex, a.get(i));
                } else if (a.get(i) ==1 ) {
                     firstIndex = 1;
                 }
            }
        }
    }
    public static void main(String[] args) {

    }
}
