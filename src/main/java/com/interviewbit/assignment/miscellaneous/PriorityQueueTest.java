import java.util.PriorityQueue;

/**
 * Created by avsrivathsan on 6/1/2017.
 */
public class PriorityQueueTest {


    private static void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(( Integer o1,  Integer o2) -> {
            if ( o1 > o2) {
                return -1;
            } else if ( o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        });

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void main(String[] args) {
        testPriorityQueue();
    }
}
