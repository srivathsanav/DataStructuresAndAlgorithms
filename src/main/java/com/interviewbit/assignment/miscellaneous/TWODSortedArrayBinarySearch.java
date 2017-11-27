import java.util.ArrayList;
import java.util.List;

/**
 * Created by avsrivathsan on 7/31/2017.
 */
public class TWODSortedArrayBinarySearch {


    public static int searchMatrix(List<ArrayList<Integer>> matrix, int b) {

        if (matrix.size() == 0) {
            return 0;
        }
        int row = 0; int column = matrix.get(0).size();

        while (row <= matrix.size() && column >= 0) {
            if (matrix.get(row).get(column) == b) {
                return 1;
            } else if (matrix.get(row).get(column) <  b) {
                row++;
            } else {
                column--;
            }
        }
        return 0;
    }

        public static void main(String[] args) {

    }
}
