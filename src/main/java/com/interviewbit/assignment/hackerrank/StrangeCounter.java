import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class StrangeCounter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long t = in.nextLong();
        printCounterValue1(t);
    }

    private static void printCounterValue(int t) {
        long val[] = new long[t];
        val[0] = 3;
        long counterStartValue = 3;
        for (int i = 1; i < t; i++) {
            if (val[i - 1] != 1) {
                val[i] = val[i - 1] - 1;
            } else {
                val[i] = counterStartValue * 2;
                counterStartValue = val[i];
            }
        }
        System.out.println(val[t - 1]);
    }

    private static void printCounterValue1(long t) {
        int n = 3;
        //find k t =( 2^k -1) n + 1
        int k = 0;
        long twoPowerk = (long)Math.pow(2, k);
        long tValue = ((twoPowerk -1) * n + 1);
        while (tValue <= t) {
            k++;
            twoPowerk = (long)Math.pow(2, k);
            tValue = ((twoPowerk -1) * n + 1);
        }
        k = k - 1;
        twoPowerk = (long)Math.pow(2, k);
        long valueofN = twoPowerk * n ;
        long tInstance = (long)(Math.pow(2,k) -1) * n + 1;
        long remainder = t - (tInstance);
        System.out.println(valueofN - remainder);


    }
}