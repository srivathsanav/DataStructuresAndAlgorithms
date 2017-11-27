import java.util.Arrays;
import java.util.Collections;

/**
 * Created by avsrivathsan on 8/2/2017.
 */
public class CircularQueue {

    private int[] elements;

    private int head = 0; int tail = 0;

    int capacity = 0;

    int numberOFElements = 0;

    public CircularQueue(int initialCapacity) {
        elements = new int[initialCapacity];
    }

    public int capacity() {
        return numberOFElements;
    }

    public void enqueue(int number) {
        elements[tail] = number;
        tail = (tail + 1) % capacity;
        numberOFElements++;
        if (numberOFElements == capacity) {
            Collections.rotate(Arrays.asList(elements), -head);
            Arrays.copyOf(elements, capacity * 2);
        }
    }

    public int dequeue() {
        if (numberOFElements == 0) {
            throw new IllegalStateException("Array Empty");
        }
        int removedElement = elements[head];
        head = (head + 1) % capacity;
        numberOFElements--;
        return removedElement;
    }
}
