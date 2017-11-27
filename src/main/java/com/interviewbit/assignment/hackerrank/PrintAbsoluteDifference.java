import java.util.Scanner;

/**
 * Created by srivathsan on 10/9/17.
 */
public class PrintAbsoluteDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        findAbsoluteDifference(a);
    }

    private static void findAbsoluteDifference(int[] input) {
        int count[] = new int[100];
        for (int i = 0 ; i < input.length; i++) {
            count[input[i]]++;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < count.length; i++) {
            int sum = count[i] + count[i-1];
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);

    }
}
