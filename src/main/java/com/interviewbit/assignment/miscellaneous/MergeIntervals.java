import java.util.*;

/**
 * Created by avsrivathsan on 7/28/2017.
 */
public class MergeIntervals {

    static class Interval implements  Comparable<Interval> {
        int start;

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Interval o) {
            int diff = Integer.compare(start, o.start);
            if (diff != 0) {
                return diff;
            } else {
                return Integer.compare(end, o.end);
            }

        }
    }

    static class Mycomparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start - o2.start != 0) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }

        }
    }

    public  ArrayList<Interval>   mergeIntervals(List<Interval> intervals, Interval intervalToBeAdded) {
        ArrayList<Interval> unionIntervals = new ArrayList<>();
        int startPoint = intervalToBeAdded.start;
        int endPoint = intervalToBeAdded.end;

        int i = 0;

        while ( i < intervals.size() && intervalToBeAdded.start > intervals.get(i).end) {
            unionIntervals.add(intervals.get(i++));
        }
        int startInterval = intervalToBeAdded.start;
        int endInterval = intervalToBeAdded.end;
        while (i < intervals.size() && intervalToBeAdded.end >= intervals.get(i).start) {
            startInterval = Math.min(startInterval, intervals.get(i).start);
            endInterval = Math.max(endInterval, intervals.get(i).end);
            i++;
        }
        unionIntervals.add(new Interval(startInterval, endInterval));
        unionIntervals.addAll(intervals.subList(i, intervals.size()));
        return unionIntervals;

    }

    public  static ArrayList<Interval>   merge(List<Interval> intervals) {
        ArrayList<Interval> unionIntervals = new ArrayList<>();
        Collections.sort(intervals, new Mycomparator());

        for (int k = 0; k < intervals.size(); k++) {
            int startInterval = intervals.get(k).start;
            int endInterval = intervals.get(k).end;
            for (int j = k +1; j < intervals.size(); j++) {
                if ( endInterval >= intervals.get(j).start) {
                    startInterval = Math.min(startInterval, intervals.get(j).start);
                    endInterval = Math.max(endInterval, intervals.get(j).end);
                    k++;
                }
            }
            unionIntervals.add(new Interval(startInterval, endInterval));
        }

        return unionIntervals;

    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(10, 10));

        System.out.println(merge(intervals));
    }
}
