import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 7/31/2017.
 */
public class SortedArraySearch {
    public static int search(final List<Integer> a, int b) {

        int right = a.size() - 1;
        int left = 0;

        while (left < right) {
            int middle = left + (right - left) /2;
            if (a.get(middle) < a.get(right)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        int pivotPoint = left;
        if (a.get(pivotPoint) == b ) {
            return pivotPoint;
        }
        //Binary search left side
        int value = binarySearch(a, b, 0, pivotPoint -1 );
        if ( value != -1 ) {
            return value;
        } else {
            return binarySearch(a, b, pivotPoint+1, a.size()-1 );
        }

    }

    private static int binarySearch(List<Integer> a, int b, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (high +low) /2 ;
            if (a.get(mid) == b) {
                return mid;
            } else  if (a.get(mid) < b) {
                low = mid +1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(Arrays.asList( 2, 3, 4, 5, 1), 1 ));
    }

    }
