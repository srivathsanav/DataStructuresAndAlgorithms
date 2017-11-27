/**
 * Created by avsrivathsan on 7/11/2017.
 */
public class PeakElement {

    private static void findPeak(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if ( i != array.length - 1) {
                if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                    System.out.println("Peak Element" + array[i]);
                }
            } else {
                if (array[i - 1] < array[i] ) {
                    System.out.println("Peak Element" + array[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        findPeak(new int[] {1,4,3,6,7,10});
    }
}
