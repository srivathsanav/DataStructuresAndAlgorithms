package com.interviewbit.assignment.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by srivathsan on 08/10/15.
 */


public class IntervalTest2 {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new IntervalTest2().new Mycomparator());

        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (overlap(intervals.get(i), intervals.get(j))) {

                    Interval newinterval = new Interval(
                            Math.min(intervals.get(i).start,
                                    intervals.get(j).start),
                            Math.max(intervals.get(i).end, intervals.get(j).end));
                    intervals.remove(i);
                    intervals.remove(i);
                    intervals.add(i, newinterval);
                    if (i > 0) {
                        i--;
                    }
                    if (j > 0) {
                        j--;
                    }
                }

            }

        }
        return intervals;
    }

    private static boolean overlap(Interval i1, Interval i2) {

        if (Math.max(i1.start, i2.start) > Math.min(i1.end, i2.end)) {
            return false;
        }
        return true;
    }

    class Mycomparator implements Comparator<Interval> {

        public int compare(Interval o1, Interval o2) {
            if (o1.start - o2.start != 0) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }

        }
    }
}
