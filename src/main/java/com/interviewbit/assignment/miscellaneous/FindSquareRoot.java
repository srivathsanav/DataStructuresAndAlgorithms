import java.util.List;

/**
 * Created by avsrivathsan on 7/31/2017.
 */
public class FindSquareRoot {



    private static int binarySearch(int number) {

        long low = 1;
        long high = number ;
        long mid;
        while (low <= high) {
             mid = high - ((high-low)/2);
            if (mid * mid == number) {
                return(int) mid;
            } else  if (mid * mid < number) {
                low = mid +1;
            } else {

                high = mid - 1;
            }
            System.out.println(mid + " " + low  +  " " + high);

        }
        return (int)low - 1;
    }


    public static void main(String[] args) {
        System.out.println(binarySearch(17));
    }

}
