/**
 * Created by avsrivathsan on 8/9/2017.
 */
public class Palindrome {

    private static boolean isValidPalindrome(String inputString) {
        for (int i = 0, j = inputString.length() -1 ; i < j; i++, j--) {
            if (!isAlphaNumeric(inputString.charAt(i))) {
                i++;
                break;
            }
            if (!isAlphaNumeric(inputString.charAt(j))) {
                j--;
                break;
            }
            if (inputString.toUpperCase().charAt(i) != inputString.toUpperCase().charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(char input){
        if (Character.isAlphabetic(input) || Character.isDigit(input)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal, Panama"));
        System.out.println(isValidPalindrome("Able was I, ere I saw Elba!"));
        System.out.println(isValidPalindrome("SS"));

    }
}
