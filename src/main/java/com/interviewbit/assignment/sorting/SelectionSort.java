package com.datastructures.sorting;

import java.util.Arrays;

/**
 * Created by srivathsan on 17/02/17.
 */
public class SelectionSort {

    private static void selectionSort(int[] input) {

        for (int i =0; i <= input.length -1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i ; j <= input.length -1 ; j++) {
                if (input[j] < min) {
                    min = input[j];
                    minIndex = j;
                }
            }
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }
        for (int i = 0 ; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void main(String[] args) {
        selectionSort(new int[]{10, 8, 6, 1, 2, 9, 7});

    }
}
