import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class Median {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int array1[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            array1[B_i] = in.nextInt();
        }
        Arrays.sort(array1);
        System.out.println(array1[array1.length/2]);
    }
}
