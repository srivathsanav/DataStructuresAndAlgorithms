import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by avsrivathsan on 6/19/2017.
 */
public class Medians {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            input[a_i] = in.nextInt();
            adjustHeap(input[a_i]);
            printMedian(input[a_i]);
        }
    }

    static PriorityQueue<Integer>  maxPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * (o1.compareTo(o2));
        }
    });

    static PriorityQueue<Integer>  minPriorityQueue = new PriorityQueue<>();

    private static void adjustHeap(int input) {
        if (maxPriorityQueue.size() == 0 ) {
            maxPriorityQueue.add(input);
        } else if (maxPriorityQueue.peek() < input) {
            minPriorityQueue.add(input);
        } else {
            maxPriorityQueue.add(input);
        }

        PriorityQueue<Integer> bigger = maxPriorityQueue.size() > minPriorityQueue.size() ? maxPriorityQueue : minPriorityQueue;
        PriorityQueue<Integer> smaller = maxPriorityQueue.size() <= minPriorityQueue.size() ? maxPriorityQueue : minPriorityQueue;

        int difference = bigger.size() - smaller.size();

        if (difference > 1) {
            smaller.add(bigger.poll());
        }
    }

    private static void printMedian(int input) {
        double median = 0.0;
        PriorityQueue<Integer> bigger = maxPriorityQueue.size() > minPriorityQueue.size() ? maxPriorityQueue : minPriorityQueue;
        PriorityQueue<Integer> smaller = maxPriorityQueue.size() <= minPriorityQueue.size() ? maxPriorityQueue : minPriorityQueue;

        if (bigger.size() == smaller.size()) {
            System.out.println(((double) bigger.peek() + smaller.peek()) /2);
        } else {
            System.out.println((double)bigger.peek());
        }
    }
}
