package com.interviewbit.assignment.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 28/01/16.
 */
public class Stocks {
    public int maxProfit(final List<Integer> a) {
        int maxProfit = 0;
        int buyday = 0;
        int sellday = 1;
        for (; sellday < a.size() ;sellday++) {
            if (a.get(sellday) - a.get(buyday) <= 0) {
                buyday = sellday;
            }
            maxProfit = Math.max(a.get(sellday) - a.get(buyday), maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Stocks().maxProfit(Arrays.asList(100, 10, 50, 0, 20)));
    }
}
