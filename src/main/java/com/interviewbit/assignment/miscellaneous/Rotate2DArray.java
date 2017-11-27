import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 8/7/2017.
 */
public class Rotate2DArray {

    private static void rotate2DArray(List<List<Integer>> matrix) {
        int matrixSize = matrix.size() - 1;

        for (int i = 0; i < (matrix.size()/2); i++) {
            for (int j = i; j < matrixSize - i; j++) {
                int temp1 = matrix.get(matrixSize- j).get(i);
                int temp2 = matrix.get(matrixSize-i).get(matrixSize-j);
                int temp3 = matrix.get(j).get(matrixSize - i);
                int temp4 = matrix.get(i).get(j);

                System.out.println( temp1 + " " + temp2 + " " + temp3 + " " + temp4);

                matrix.get(i).set(j, temp1);
                matrix.get(matrixSize - j).set(i, temp2);
                matrix.get(matrixSize-i).set(matrixSize-j, temp3);
                matrix.get(j).set(matrixSize-i, temp4);
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 8));
        matrix.add(Arrays.asList(9, 10, 11, 12));
        matrix.add(Arrays.asList(13, 14, 15, 16));
        System.out.println(matrix);
        rotate2DArray(matrix);
    }
}
