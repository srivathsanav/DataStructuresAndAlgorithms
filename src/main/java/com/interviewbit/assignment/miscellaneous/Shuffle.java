package com.datastructures;

/**
 * Created by srivathsan on 20/02/17.
 */
public class Shuffle {

    private static void shuffle(int[] a) {
        int n = a.length/2;
        int j = 1;
        for (int i =n; i < a.length; i++) {
            //move by n-1
            int temp = a[i];
            int newPosition = i - (n-j);
            for (int k = i-1 ; k >=newPosition; k--) {
                a[k+1] = a[k];
            }
            a[newPosition] = temp;
            j++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
       shuffle(new int []{1, 3, 5, 7, 2, 4, 6, 8} );
    }
}
