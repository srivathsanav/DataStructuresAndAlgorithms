import java.util.Scanner;

/**
 * Created by srivathsan on 10/9/17.
 */
public class VisaTestOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
    }
}
