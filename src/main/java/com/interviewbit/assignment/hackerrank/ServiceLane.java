import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        for(int width_i=0; width_i < n; width_i++){
            width[width_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < t; a0++){
            int i = in.nextInt();
            int j = in.nextInt();
            finLargestVehicleThatCanPass(width, i, j);
        }
    }


    private static void finLargestVehicleThatCanPass(int[] width, int startIndex, int endIndex) {
        int minimum = Integer.MAX_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            if (width[i] < minimum) {
                minimum = width[i];
            }
        }
        System.out.println(minimum);
    }
}
