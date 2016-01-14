package com.interviewbit.assignment.HackerEarthProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 class TestClass1 {

    public static void main(String[] args) {
        try {
            TestClass1 tc = new TestClass1();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            while (T-->0) {
                int N, K, M;
                String nkm[] = br.readLine().split(" ");
                N = Integer.parseInt(nkm[0]);
                K = Integer.parseInt(nkm[1]);
                M = Integer.parseInt(nkm[2]);
                String arr[] = new String[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = br.readLine();
                }
                tc.mergeSort(arr, 0, N-1, M);
                System.out.println(arr[K-1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void mergeSort(String arr[], int low, int high, int stop) {
        if(low < high){
            int middle = low+(high-low)/2;
            mergeSort(arr, low, middle, stop);
            mergeSort(arr, middle+1, high, stop);
            merge(arr, low, middle, high, stop);
        }
    }

    private void merge(String arr[], int low, int middle, int high, int stop) {
        String tempArr[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        int i = low;
        int j = middle+1;
        int k = low;
        while (i <= middle && j <= high) {
            if (myStrCompare(tempArr[i], tempArr[j], stop) < 1) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = tempArr[i];
            k++;
            i++;
        }

    }

    private int myStrCompare(String str1, String str2, int stop) {
        int stopLength = stop;
        int i = 0;
        int str1_length = str1.length();
        int str2_length = str2.length();
        if (str1_length > str2_length){
            stopLength = str2_length > stop ? stop : str2_length;
        }
        else {
            stopLength = str1_length > stop ? stop : str1_length;
        }
        for (i = 0; i < stopLength && str1.charAt(i) == str2.charAt(i); i++);
        return(str1.charAt(i) - str2.charAt(i));
    }

}