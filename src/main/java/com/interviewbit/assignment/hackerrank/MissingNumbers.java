import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int array1[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            array1[B_i] = in.nextInt();
        }

        int N2 = in.nextInt();
        int array2[] = new int[N2];
        for(int B_i=0; B_i < N2; B_i++){
            array2[B_i] = in.nextInt();
        }
        missingNumbers(array1, array2);
    }

    private static void missingNumbers(int[] array1, int[] array2) {
        //Count numbers in array2
        //Calculate mimimum
        int mimimumValue = Integer.MAX_VALUE;
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < mimimumValue) {
                mimimumValue = array2[i];
            }
        }
        // Now start couting in array2
        int[] count2 = constructCountArray(array2, mimimumValue);
        int[] count1 = constructCountArray(array1, mimimumValue);

        printDeltaBetweenArrays(count1, count2, mimimumValue);
    }

    private static int[] constructCountArray(int[] array, int mimimum) {
        int[] count = new int[100];
        for (int i = 0; i < array.length; i++) {
            count[array[i]-mimimum]++;
        }
        return count;
    }

    private static void printDeltaBetweenArrays(int[] count1, int[] count2, int mimimumValue) {

        for (int i = 0; i < count2.length; i++) {
            if (count1[i] < count2[i]) {
                System.out.println(i + mimimumValue + " ");
            }
        }
    }
}
