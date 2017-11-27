/**
 * Created by avsrivathsan on 5/25/2017.
 */
public class ReverseNumber {

    private static int reverseNumber( int number) {
        int rem = 0;
        while (number > 0) {
            rem =  number % 10 + (int)(( rem) * 10);
            number = number / 10;
        }
        return (int)rem;
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(531));
    }
}
