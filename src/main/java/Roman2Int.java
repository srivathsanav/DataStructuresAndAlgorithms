package com.interviewbit.assignment;

import java.util.HashMap;

/**
 * Created by srivathsan on 23/10/15.
 */
public class Roman2Int {

    public static int romanToInt(String a) {
        HashMap<String,Integer> myMap = new HashMap<String, Integer>();
        int val = 0;
        myMap.put("I", 1);
        myMap.put("V", 5);
        myMap.put("X", 10);
        myMap.put("L", 50);
        myMap.put("C", 100);
        myMap.put("D", 500);
        myMap.put("M", 1000);
        for (int i = a.length()-1; i >= 0; i--) {
            if (myMap.get(a.charAt(i)+"") != null) {
                    if (i != a.length()-1 && a.charAt(i) !=  a.charAt(i+1)) {
                         if (myMap.get(a.charAt(i)+"") < myMap.get(a.charAt(i+1)+"")) {
                             val -=   myMap.get(a.charAt(i) + "") ;
                        } else {
                             val += myMap.get(a.charAt(i) + "");
                         }

                    } else {

                        val += myMap.get(a.charAt(i) + "");
                    }
            }
        }
        return  val;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IIX"));
    }
}
