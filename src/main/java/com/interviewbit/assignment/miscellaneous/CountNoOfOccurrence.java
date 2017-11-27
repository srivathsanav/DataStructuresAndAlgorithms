import java.util.List;

/**
 * Created by avsrivathsan on 1/2/2017.
 */
public class CountNoOfOccurrence {

    public int findCount(final List<Integer> a, int b) {
        return 0;
    }

    private static int binarySearch(final List<Integer> a, int low, int high, int b) {
        int mid = (low + high) /2;

        while (low <= high) {
            if (a.get(mid) <= b) {
                high = mid -1;
            } else if (a.get(mid) > b) {
                low = mid +1;
            }
        }
        return 0;

    }

    private Node sortedArrayToBST(int array[], int low, int high) {
        if( high > low) {
            return null;
        }
        int mid = (low + high) /2;

         Node node = new Node();
        node.setData(array[mid]);
        node.setLeft(sortedArrayToBST(array, low, mid-1));
        node.setRight(sortedArrayToBST(array, mid+1, high));
        return node;

    }

        public static void main(String[] args) {

    }
}
