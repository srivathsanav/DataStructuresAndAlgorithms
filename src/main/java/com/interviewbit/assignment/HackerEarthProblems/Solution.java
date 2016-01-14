package com.interviewbit.assignment.HackerEarthProblems;

import java.util.*;
;

/**
 * Created by srivathsan on 23/09/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.next());
        int m  = Integer.parseInt(scanner.next());
        List<Long> elements = new ArrayList<Long>();
        for(int i =0; i < n; i++) {
            elements.add(0L);
        }
        long highest = 0L;
        for (int i=0 ;i < m ; i++) {
                int start = Integer.parseInt(scanner.next());
                int end =   Integer.parseInt(scanner.next());
                long value =   Integer.parseInt(scanner.next());
                for (int j = start-1; j <= end-1; j++) {
                    long addedValue = value+ elements.get(j);
                    elements.set(j, addedValue);
                    if (addedValue > highest) {
                        highest = addedValue;
                    }
                }
        }

        System.out.println(highest);

    }
}
