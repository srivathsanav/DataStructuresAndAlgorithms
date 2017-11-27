import java.util.*;

/**
 * Created by avsrivathsan on 7/29/2017.
 */
public class MergeElementsUsingMinHeap {

    static class ArrayEntry {
        int value;
        int arrayId;

        public ArrayEntry(int value, int arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    private static void mergeElementsUsingMinHeap(List<List<Integer>> inputList) {
        List<Iterator<Integer>> iterators = new ArrayList<>(inputList.size());

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(inputList.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        for (List<Integer> list : inputList) {
            iterators.add(list.iterator());
        }

        for (int i =0; i < iterators.size(); i++) {
            if (iterators.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iterators.get(i).next(), i));
            }
        }

        while(!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            System.out.println(headEntry.value);
            if (iterators.get(headEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iterators.get(headEntry.arrayId).next(), headEntry.arrayId));
           }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<>();

        inputList.add(Arrays.asList());
        inputList.add(Arrays.asList(0, 6, 7000));
        inputList.add(Arrays.asList(0, 6, 28, 101, 1000));
        mergeElementsUsingMinHeap(inputList);
    }
}
