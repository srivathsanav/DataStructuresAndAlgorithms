package com.interviewbit.assignment;

import java.util.*;

/**
 * Created by srivathsan on 28/10/15.
 */
public class Maxone {

    public  static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int count =0;

        int aLeft =0; int aRight = 0;
        int numOfZeros = 0;
        int bestLeft = -1;

        int bestRight = -1;
        int maxRange = -1;
        while (aRight < a.size())  {



            if (numOfZeros <= b) {
                if (a.get(aRight).intValue() == 0) {
                    numOfZeros++;
                }
                aRight++;
            }

            if ( numOfZeros > b) {
                if (a.get(aLeft).intValue() == 0) {
                    numOfZeros--;
                }
                aLeft++;
            }




            if ((aRight - aLeft + 1)  > maxRange) {
                maxRange = aRight - aLeft + 1;
                bestLeft = aLeft;
                bestRight = aRight;
            }

        }


        for (int i =bestLeft; i < bestRight ; i++)  {
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxone( new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1)), 1));
    }
}
