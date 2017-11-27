import java.util.ArrayList;
import java.util.List;

/**
 * Created by avsrivathsan on 9/1/2017.
 */
public class CountNoOfWays {

    private static  int countNoOfWays(int n, int m, int mat[][]){
        if (mat[n][m] == -1 ) {
            return -1;
        }
        if (m == 0 || n == 0){
            return 1;
        }
        if (mat[n][m] == 0) {
            int waysTop = countNoOfWays(n - 1, m , mat);
            waysTop = waysTop == -1 ? 0 : waysTop;



            int waysLeft = countNoOfWays(n, m-1 ,mat);
            waysLeft = waysLeft == -1 ? 0 : waysLeft;
            mat[n][m]  =  waysLeft + waysTop;
            System.out.println(n + " " + m + "  "+ mat[n][m] + "  " + waysLeft + "  " + waysTop);
        }
        return mat[n][m];
    }

    public static void main(String[] args) {
        int mat[][] = new int[4][3];
        mat[2][2] = -1;
        mat[2][0] = -1;
        mat[3][0] = -1;
        List<String> paths = new ArrayList<>();
        System.out.println(countNoOfWays(3, 2, mat));
        System.out.println(paths);
        System.out.println(mat[3][1]);
    }
}
