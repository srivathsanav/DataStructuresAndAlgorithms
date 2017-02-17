package com.datastructures.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 17/02/17.
 */
public class BubbleSort {

    private static List<Integer> bubbleSort(List<Integer> list) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0 ; i < list.size() - 1; i++) {
                while (list.get(i) > list.get(i+1)) {
                    isSorted = false;
                    int temp = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1, temp);
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(bubbleSort(Arrays.asList(10, 8, 6, 1, 2, 9, 7)));

    }
}
