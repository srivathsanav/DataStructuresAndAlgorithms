import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class SherlockNumber {

    static String solve(int[] a){
        long leftSum = 0;
        long rightSum = sum(a);

        for (int i = 0; i < a.length; i++) {
            rightSum = rightSum- a[i];
            if (leftSum == rightSum) {
                return "YES";
            } else {
                leftSum = leftSum + a[i];
            }
        }
        return "NO";
    }

    private static long sum(int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
