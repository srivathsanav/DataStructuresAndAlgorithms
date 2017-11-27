import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by avsrivathsan on 8/7/2017.
 */
public class SpialOrdering {

    private static void spiralOrdering(int n) {
        int[][] MOVE = {{0, 1} , {1,0}, {0, -1}, {-1, 0}};
        int count[] = { 1, n ,-1, -n};
        int x = 0, y = 0,nextX = 0, nextY = 0, dir = 0;
        List<Integer> spiralOrdering = new ArrayList<>();
        int countVal = 0;
        boolean[][] addedElements = new boolean[n][n];

        for (int i = 0; i < n * n ; i++) {
            countVal = countVal + count[dir];
            spiralOrdering.add(countVal);
            addedElements[x][y] = true;
            nextX = x + MOVE[dir][0]; nextY = y + MOVE[dir][1];

            if ( nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || addedElements[nextX][nextY] == true) {
                dir = (dir + 1) % 4;

                nextX = x + MOVE[dir][0]; nextY = y + MOVE[dir][1];
            }
            x = nextX;
            y = nextY;

        }
        System.out.println(spiralOrdering);
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 8));
        matrix.add(Arrays.asList(9, 10, 11, 12));
        matrix.add(Arrays.asList(13, 14, 15, 16));
        spiralOrdering(5);
    }

}
