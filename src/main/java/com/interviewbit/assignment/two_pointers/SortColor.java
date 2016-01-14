package com.interviewbit.assignment.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 23/09/15.
 */
public class SortColor {

    public static void sortColors(ArrayList<Integer> a) {
        int  zeroIndex = -1;
        int secondIndex = -1;
        int firstIndex = -1;
        int[] colors = new int[3];

        for (int i =0; i < a.size(); i++) {
            if (a.get(i).intValue() == 0) {
                colors[0]++;
            } else if (a.get(i).intValue() == 1) {
                colors[1]++;
            }  else if (a.get(i).intValue() == 2) {
                colors[2]++;
            }
        }
        int count = 0;
        for (int i =0 ; i < colors.length; i++) {
            for (int j =0; j < colors[i]; j++) {
                a.set(count++, i );
            }
        }
    }
    public static void main(String[] args) {
        ArrayList a = new ArrayList(Arrays.asList());
        sortColors(a);
        System.out.println(a);
    }
}
