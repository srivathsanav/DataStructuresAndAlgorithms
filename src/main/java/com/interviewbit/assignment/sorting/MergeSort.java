package com.datastructures.sorting;

import java.util.List;

/**
 * Created by srivathsan on 17/02/17.
 */
public class MergeSort {

    public static void main(String[] args) {
        mergeSort(new int[]{10, 9, 8, 5 , 1, 2, 14, 16, 4, 44, 100 });
    }

    private static void mergeSort(int[] input) {
        mergeSort(input, new int[input.length], 0, input.length -1);
        for (int i = 0 ; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    private static void mergeSort(int[] input, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(input, temp, leftStart, mid);
        mergeSort(input, temp, mid + 1, rightEnd);
        merge(input, temp, leftStart, rightEnd);
    }

    private static void merge(int[] input, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd  && right <= rightEnd) {
            if (input[left] < input[right]) {
                temp[index] = input[left];
                left++;
            } else {
                temp[index] = input[right];
                right++;
            }
            index++;
        }

        System.arraycopy(input, left, temp, index, leftEnd - left + 1);
        System.arraycopy(input, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, input, leftStart, size);

    }
}
