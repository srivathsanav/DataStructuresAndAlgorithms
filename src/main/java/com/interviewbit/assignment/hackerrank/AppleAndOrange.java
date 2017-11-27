import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        int appleCount = 0;
        for (int i = 0 ; i < apple.length; i++) {
            int distance = a - apple[i];
            if (distance >= s && distance <= t) {
                appleCount++;
            }
        }
        int orangeCount = 0;
        for (int i = 0 ; i < orange.length; i++) {
            int distance = b + orange[i];
            if (distance >= s && distance <= t) {
                orangeCount++;
            }
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
