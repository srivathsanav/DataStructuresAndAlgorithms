import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by srivathsan on 10/17/17.
 */
public class Dumplings {

    public static int dumplings(int input1, int[] input2) {
        int maxDumplings = 0;

        Arrays.sort(input2);
        int i = 0;
        for (; i < input2.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < input2.length; j++) {
                if (input2[j] != Integer.MIN_VALUE &&  (input2[i] +1) == input2[j])  {
                    input2[j] = Integer.MIN_VALUE;
                    if (!found)
                        maxDumplings = maxDumplings + input2[i];
                    found = true;
                }
            }
            if (found) {
                input2[i] = Integer.MIN_VALUE;
            }
        }



        for ( i = 0; i < input2.length; i++) {
            if (input2[i] != Integer.MIN_VALUE) {
                maxDumplings = maxDumplings + input2[i];
            }
        }

        return maxDumplings;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 5, 4};
       // System.out.println(dumplings(5, arr));

        int[] arr1 = {2, 3,3,3,3};
        System.out.println(dumplings(5, arr1));
    }
}
