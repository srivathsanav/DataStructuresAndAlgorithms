/**
 * Created by avsrivathsan on 8/21/2017.
 */
public class ReverseNumber1 {

    private static void revereseNumber(int number) {

        int result = 0;
        while (Math.abs(number) > 0) {
            result =  result * 10 + (number%10);
            number = number/10;
        }
        result = (number < 0) ? -result : result;
        System.out.println(result);
    }

    public static void main(String[] args) {
        revereseNumber(413);
        revereseNumber(-413);
    }
}
