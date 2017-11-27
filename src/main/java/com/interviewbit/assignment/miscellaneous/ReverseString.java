/**
 * Created by avsrivathsan on 5/25/2017.
 */
public class ReverseString {

    private static String  reverseString (String input) {
        if (input.length() < 2) {
            return input;
        } else {
            return reverseString(input.substring(1)) + input.charAt(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseString("pans"));
    }
}
