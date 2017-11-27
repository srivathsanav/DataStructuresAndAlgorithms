import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by avsrivathsan on 8/31/2017.
 */
public class ArrayRotation {

    static int[] leftRotation(int[] a, int d) {
        int b[] = Arrays.copyOf(a, a.length);
        int n = b.length;
        for (int i = 0; i < b.length; i++) {
            b[(i-d+n)%n]= a[i];
        }
        a = Arrays.copyOf(b, b.length);
       return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
