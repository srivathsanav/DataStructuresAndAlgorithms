import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class CutSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] a = new int[T];

        for(int a0 = 0; a0 < T; a0++){
            a[a0] = in.nextInt();

        }
        cutSticks(a);

    }

    private static void cutSticks(int[] sticks) {
        System.out.println(sticks.length);
        printNoofSticksAfterReduction(sticks);
    }

    private static int findMinimum(int[] sticks) {
        int min = Integer.MAX_VALUE;
        for (int i =0; i< sticks.length; i++) {
            if (sticks[i] != 0 && sticks[i] < min) {
                min = sticks[i];
            }
        }
        return min;
    }

    private static void printNoofSticksAfterReduction(int[] sticks) {
        int reducedSize = 0;

        while (reducedSize < (sticks.length - 1)) {
            int minimum = findMinimum(sticks);
            for (int i = 0; i < sticks.length; i++) {
                if (sticks[i] != 0) {
                    sticks[i] = sticks[i] - minimum;
                    if (sticks[i] == 0) {
                        reducedSize++;
                    }
                }
            }
            if (sticks.length - reducedSize == 0)
                return;
            System.out.println(sticks.length - reducedSize);
        }
    }
}
