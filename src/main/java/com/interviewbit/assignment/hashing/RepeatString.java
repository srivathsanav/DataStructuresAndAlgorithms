package com.interviewbit.assignment.hashing;

import java.util.HashMap;

/**
 * Created by srivathsan on 07/11/15.
 */
public class RepeatString {


    public static int lengthOfLongestSubstring1(String s) {
        if (s == null)
            return 0;
        char[] arr = s.toCharArray();
        int pre = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                pre = Math.max(pre, map.size());
                i = map.get(arr[i]);
                map.clear();
            }
        }

        return Math.max(pre, map.size());
    }

    public int lengthOfLongestSubstring(String a) {

        int maxLength = 0;
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();

        for (int i = 0; i < a.length(); i++) {
            if (myMap.get(a.charAt(i)) == null) {
                myMap.put(a.charAt(i), i);
            } else {
                int length = i - myMap.get(a.charAt(i));
                if (length > maxLength) {
                    maxLength = length;
                }
                i = myMap.get(a.charAt(i));
                myMap.clear();
            }
        }
        maxLength = maxLength < myMap.size() ? myMap.size() : maxLength;
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(new RepeatString().lengthOfLongestSubstring("AXRlzkqLaa97"));
        System.out.println(new RepeatString().lengthOfLongestSubstring1("AXRlzkqLaa97"));

    }
}