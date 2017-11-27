import java.util.Arrays;

/**
 * Created by avsrivathsan on 12/26/2016.
 */
public class LinearSearch {

    public static int getMaxRepeatitions(Integer args[]) {
        int max = 0;
        int maxNo = -1;
        for (int i =0; i < args.length - 1; i++) {
            int counter = 0;
            while ( i < (args.length-1) && args[i] == (args[i+1])) {
                counter++;
                i++;
            }
            if ( max < counter) {
                max = counter;
                maxNo = args[i];
            }
        }
        return maxNo;
    }

    public static void main(String[] args) {
        System.out.println(getMaxRepeatitions(new Integer[]{1, 2, 3, 3, 3, 4, 4, 4, 4, 5}));
    }
}
