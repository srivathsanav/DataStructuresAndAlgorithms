package com.datastructures.sorting;

import java.util.Arrays;

/**
 * Created by srivathsan on 17/02/17.
 */
public class QuickSort {

    private static void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex -1);
        quickSort(input, pivotIndex + 1, end);
    }

    private static void quickSort(int [] input) {
        quickSort(input, 0, input.length - 1);
        for (int i = 0 ; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    private static int partition(int[] input, int start, int end) {
        int pivotIndex = start ;
        int pivot = input[end];

        for (int i = start; i <= end - 1; i++) {
            if (input[i] <= pivot) {
                //System.out.println(pivotIndex + " " + i);
                int temp = input[pivotIndex];
                input[pivotIndex] = input[i];
                input[i] = temp;
                pivotIndex++;

            }
        }

        int temp = input[pivotIndex ];
        input[pivotIndex ] = input[end];
        input[end ] = temp;
        return pivotIndex ;
    }

    private static void swap(int[] input, int sourceIndex, int destIndex) {

    }

    public static void main(String[] args) {
        quickSort(new int[]{2, 1, 3});

    }

}
