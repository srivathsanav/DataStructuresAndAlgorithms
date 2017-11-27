import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class Squares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i=0; i < testCases; i++){
            long startInterval = in.nextLong();
            long endInterval = in.nextLong();
            System.out.println(squareNumbers(startInterval, endInterval));
        }

    }

    private static int squareNumbers(long start, long end) {
        long squareRoot = (long) Math.floor(Math.sqrt(start));
        long squaredNumber = squareRoot * squareRoot;
        if (squaredNumber < start) {
            start = squaredNumber + 2 * squareRoot + 1;
        }
        int count = 0;
        for (long i = start; i <= end; i = i + 2 * squareRoot + 1) {
            long squareRootInLoop = (long)Math.sqrt(i);
            if (squareRootInLoop * squareRootInLoop == i) {
                count++;
            }
            squareRoot = (long)Math.sqrt(i);
        }
        return count;
    }
}
