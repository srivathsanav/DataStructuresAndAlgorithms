import java.util.ArrayList;
import java.util.List;

/**
 * Created by avsrivathsan on 7/27/2017.
 */
public class PascalTriangle {

    public static ArrayList<Integer> getRow(int n) {
        n = n + 1;
        int[][] pascal = new int[n][n];

        for (int i =0 ; i < n ; i++) {
            pascal[i][0] = 1;
        }
        for (int i =0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == j) {
                    pascal[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = pascal[i-1] [j-1] + pascal[i-1][j];
            }
        }

        ArrayList<Integer> output = new ArrayList<>();

        for (int k = 0; k < n; k ++) {
            output.add(pascal[n-1][k]);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
