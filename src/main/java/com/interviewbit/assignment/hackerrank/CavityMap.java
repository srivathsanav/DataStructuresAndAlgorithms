import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class CavityMap {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        markCavity(grid);
    }

    private static void markCavity(String[] grid) {
        for (int k = 1; k < grid.length -1; k++) {
            String cell = grid[k];
            char[] value = cell.toCharArray();
            grid[k] = constructCavityString(value, grid[k-1].toCharArray(), grid[k+1].toCharArray());
        }

        for (int i = 0 ; i < grid.length;i++) {
            System.out.println(grid[i]);
        }

    }

    private static String constructCavityString(char[] value, char[] previousValue, char[] nextValue) {
        for (int i = 1; i < value.length - 1; i++) {

            if (value[i - 1] == 'X' || previousValue[i] == 'X') {
                continue;
            }
            if (Integer.valueOf(value[i + 1]) < Integer.valueOf(value[i]) && Integer.valueOf(nextValue[i]) < Integer.valueOf(value[i]) &&
                Integer.valueOf(value[i - 1]) < Integer.valueOf(value[i]) &&  Integer.valueOf(previousValue[i]) < Integer.valueOf(value[i])  ) {
                value[i] = 'X';
            }
        }
        return new String(value);
    }


}
