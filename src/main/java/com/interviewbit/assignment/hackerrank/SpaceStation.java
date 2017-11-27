import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */

public class SpaceStation {

    private static void printMaxDistance(int n, int[] spaceStation) {
        int maxDistance = Integer.MIN_VALUE;

        for (int i =0; i < n; i++) {
            int minDistanceFromCity = Integer.MAX_VALUE;
            for (int j = 0; j < spaceStation.length; j++) {
                int distance = Math.abs(i - spaceStation[j]);
                if (distance < minDistanceFromCity) {
                    minDistanceFromCity = distance;
                }
            }
            if (minDistanceFromCity > maxDistance) {
                maxDistance = minDistanceFromCity;
            }
        }
        System.out.println(maxDistance);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        printMaxDistance(n, c );
    }
}
