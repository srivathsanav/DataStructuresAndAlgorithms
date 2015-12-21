package com.interviewbit.assignment;

import java.util.ArrayList;

/**
 * Created by srivathsan on 17/10/15.
 */
public class Spiral2 {

    public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<ArrayList<Integer>>();
        int top = 0;
        int bottom = a -1;
        int left = 0;
        int right = a -1;
        int dir = 0;
        int counter = 0;
        for (int i = 0 ; i < a; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j =0; j < a; j++) {
                list.add(0);
            }
            spiralMatrix.add(list);
        }
        while (top <= bottom && left <= right) {
            //left to right
            if (dir == 0) {
                ArrayList topRow = spiralMatrix.get(top);
                for (int i = left; i <=right; i++) {
                   topRow.set(i, ++counter);
                }
                top++; dir =1;
            } else if (dir == 1) {
                for (int i = top; i <=bottom; i++) {
                    ArrayList<Integer> lastColumn =spiralMatrix.get(i);
                    lastColumn.set(right, ++counter);
                }
                right --; dir = 2;
            } else if (dir == 2) {
                ArrayList<Integer> bottomRow = spiralMatrix.get(bottom);
                for (int i = right; i >=left; i--) {
                    bottomRow.set(i, ++counter);
                }
                bottom--; dir = 3;
            }  else if (dir == 3) {
                for (int i = bottom; i >=top; i--) {
                    ArrayList<Integer> firstColumn = spiralMatrix.get(i);
                    firstColumn.set(left, ++counter);
                }
                left++; dir = 0;
            }
        }
        return  spiralMatrix;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(0));
    }
}
