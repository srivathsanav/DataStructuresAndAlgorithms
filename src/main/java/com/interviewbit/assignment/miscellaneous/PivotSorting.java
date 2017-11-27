import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by avsrivathsan on 8/3/2017.
 */
public class PivotSorting {

    private static void sortUsingPivot(List<Integer> elements, int pivot) {

        int pivotElement = elements.get(pivot);
        int smaller = 0;
        for (int i = 0; i < elements.size(); i++ ) {
            if (elements.get(i) < pivotElement) {
                Collections.swap(elements, i, smaller);
                smaller++;
            }
        }
        System.out.println(elements);

        int greater = elements.size()-1;
        for (int i = elements.size() - 1; i >= 0; i-- ) {
            if (elements.get(i) > pivotElement) {
                Collections.swap(elements, i, greater);
                greater--;
            }
        }
        System.out.println(elements);
    }

    public static void main(String[] args) {
        sortUsingPivot(Arrays.asList( 10, 20, 100, 15, 10, 5, 0, -1, 25), 3);
    }
}
