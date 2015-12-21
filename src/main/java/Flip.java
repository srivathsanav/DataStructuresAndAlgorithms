package com.interviewbit.assignment;

import java.util.*;

/**
 * Created by srivathsan on 18/10/15.
 */
public class Flip {

    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> flipIntervals = new ArrayList<Integer>();
        int maxZeroCount = 0;
        int zeroStartIndex = 0;
        int zeroEndIndex =  0;

        int currentZeroCount = 0;
        int currentStartIndex = 0;
        int currentEndIndex = 0;
        boolean foundNow = false;
        boolean firstZero = false;
        Map<Integer, ArrayList<Integer>> indexMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
        for (int i =0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                if (!firstZero || currentZeroCount < 0) {
                    currentStartIndex = i;
                }

                firstZero = true;

                currentZeroCount++;

                if (currentZeroCount > maxZeroCount) {
                    zeroStartIndex = currentStartIndex;
                    maxZeroCount = currentZeroCount;
                    foundNow = true;
                }
            } else {
                    currentZeroCount--;
                if (foundNow) {
                    zeroEndIndex = i-1;
                    foundNow = false;
                    ArrayList<Integer> flipInterval = new ArrayList<Integer>();
                    flipInterval.add(zeroStartIndex+1);
                    flipInterval.add(zeroEndIndex+1);
                    indexMap.put(maxZeroCount, flipInterval);
                }
            }
        }
        if (zeroEndIndex!= 0 && zeroEndIndex < zeroStartIndex) {
            zeroEndIndex = zeroStartIndex;
        } else if (zeroEndIndex == 0 && A.charAt(A.length() -1) == '0' ) {
            zeroEndIndex = A.length() -1;
        }
        if (maxZeroCount <= currentZeroCount && zeroEndIndex  > 0) {
            List<Integer> flipInterval = new ArrayList<Integer>();
            flipIntervals.add(zeroStartIndex + 1);
            flipIntervals.add(zeroEndIndex + 1);
            if (indexMap.get(maxZeroCount) != null) {
                int existingStartIndex = indexMap.get(maxZeroCount).get(0);
                if (existingStartIndex > (zeroStartIndex+1)) {
                    indexMap.put(maxZeroCount, flipIntervals);

                } else if (existingStartIndex == (zeroStartIndex+1)) {
                    int existingEndIndex = indexMap.get(maxZeroCount).get(1);
                    if (existingEndIndex > (zeroEndIndex +1)) {
                        indexMap.put(maxZeroCount, flipIntervals);

                    }
                }
            } else {
                indexMap.put(maxZeroCount, flipIntervals);

            }

        }
        int maxCount = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> map : indexMap.entrySet()) {
            if (maxCount < map.getKey()) {
                maxCount = map.getKey();
            }
        }
        if (indexMap.get(maxCount) != null) {
            return  indexMap.get(maxCount);
        }

        return  flipIntervals;
    }

    public static void main(String[] args) {
        System.out.println(flip("0111000100010"));
    }
}
