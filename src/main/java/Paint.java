package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 20/10/15.
 */
public class Paint {

    public static int paint(int a, int b, ArrayList<Integer> c) {
         int nooFpainters = a;
         int timeForEachPaint = b;
         int totalBoards = c.size();
         long low = 0;
         long high =   Long.MAX_VALUE;
         long mid = 0;
         long ans = 0;
         long totalPaintingTime = 0;
         for (int i = 0; i < totalBoards; i++ ) {
              totalPaintingTime = totalPaintingTime + c.get(i);
         }
         while (low <= high) {
             mid = high - ((high - low)/2);
             if (isPossible(nooFpainters, timeForEachPaint, mid , totalPaintingTime , c)) {
                ans = mid;
                 high = mid -1;
             } else {
                 low = mid +1;
             }
         }
         return (int)((ans*timeForEachPaint) % 10000003);

    }

    static boolean isPossible (int nooFPainters, int timeForEachPaint, long totalTimeToPaintAvailableNow,  long totalPaintingTime, ArrayList<Integer> boards) {
        if (totalTimeToPaintAvailableNow < totalPaintingTime / nooFPainters)
            return  false;
         int numberOfBoards = boards.size();
        long sumCurrentTimeTaken = Long.MIN_VALUE;
        int index = 0;
        for (int i = 0 ; i < nooFPainters && index < numberOfBoards; i++)  {
            long timetakenForCurrentBoard = totalTimeToPaintAvailableNow;

            while (index < numberOfBoards) {
                   if (timetakenForCurrentBoard - boards.get(index) >= 0 ) {
                       timetakenForCurrentBoard = timetakenForCurrentBoard - boards.get(index);
                       index++;
                   } else {
                       break;
                   }

             }
        }

        if (index < numberOfBoards) {
            return  false;
        }

        return  true;
    }

    public static void main(String[] args) {
        System.out.println(paint(2, 5, new ArrayList<Integer>(Arrays.asList(1,10))));
    }
}
