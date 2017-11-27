package com.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srivathsan on 23/02/17.
 */
public class MaxSlidingWindow {

    private static boolean maxSlidingWindow(String input, String pattern) {
        char[] inputArray = input.toCharArray();
        Map<Character, Integer> needToFind = new HashMap<>();

        // Process pattern array
        for (int i = 0; i < pattern.length(); i++) {
            if (needToFind.get(pattern.charAt(i)) != null) {
                int count = needToFind.get(pattern.charAt(i));
                needToFind.put(pattern.charAt(i), ++count);
            } else {
                needToFind.put(pattern.charAt(i), 1);
            }
        }

        Map<Character, Integer> hasFound = new HashMap<>();
        int count = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minWindowBegin = 0;
        int minWindowEnd = 0;

        for (int begin = 0, end = 0; end < input.length(); end++) {

            if (needToFind.get(input.charAt(end)) == null) {
                continue;
            }

            // Populate hasFound map
            if (hasFound.get(input.charAt(end)) != null) {
                hasFound.put(input.charAt(end), hasFound.get(input.charAt(end)) + 1);
            } else {
                hasFound.put(input.charAt(end), 1);
            }


            if (hasFound.get(input.charAt(end)) <= needToFind.get(input.charAt(end))) {
                count++;
            }

            if (count == pattern.length()) {
                //Stretch start

                while ( begin < input.length() && (hasFound.get(input.charAt(begin)) == null ||
                        hasFound.get(input.charAt(begin)) > needToFind.get(input.charAt(begin)))) {
                    if (hasFound.get(input.charAt(begin))!= null && hasFound.get(input.charAt(begin)) > needToFind.get(input.charAt(begin))) {
                        hasFound.put(input.charAt(begin), hasFound.get(input.charAt(begin)) - 1);
                    }
                    begin++;
                }
                int windowLength =  end - begin + 1;

                if (windowLength < minWindowSize) {
                    minWindowBegin = begin;
                    minWindowEnd = end;
                    minWindowSize = windowLength;
                }

            }
        }
        boolean found =(count == pattern.length());
        if (found) {
            System.out.println("Sliding Window " + input.substring(minWindowBegin, minWindowEnd + 1));
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow("ADOBECODEBANC", "ABC"));
    }


}
