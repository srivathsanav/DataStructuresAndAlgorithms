import java.util.ArrayList;
import java.util.List;

/**
 * Created by avsrivathsan on 9/1/2017.
 */
public class PalindromicDecompositions {

    private static void generateAllPalindromicDecompositions(List<List<String>> result,
                                                                           int offset, List<String> intermediateString, String input) {
        if (offset == input.length() ) {
            result.add(new ArrayList<>(intermediateString));
        }

        for (int i = offset + 1; i <= input.length(); i++) {
            String prefix = input.substring(offset, i);
            if (isValidPalindrome(prefix)) {
                intermediateString.add(prefix);
                generateAllPalindromicDecompositions(result,  i,intermediateString, input );
                intermediateString.remove(intermediateString.size() - 1);
            }
        }
    }

    private  static boolean isValidPalindrome(String prefix) {
        for (int i = 0, j = prefix.length() -1 ; i <j; i++ , j--) {
            if (prefix.charAt(i) != prefix.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();

       generateAllPalindromicDecompositions( result, 0 , new ArrayList<>(),
                "0204451881");
        System.out.println(result);
    }
}
