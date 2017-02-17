package com.datastructures.sorting;

/**
 * Created by srivathsan on 17/02/17.
 */
public class InsertionSort {

    private static void insertionSort(int[] input) {
        for (int j = 1; j < input.length; j++) {
            for (int i =0; i < j; i++) {
                if (input[j] < input[i]) {
                    int temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }
        for (int i = 0 ; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void main(String[] args) {
        insertionSort(new int[]{3,2, 1});

    }
}
