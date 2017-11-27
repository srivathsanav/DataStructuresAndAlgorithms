/**
 * Created by avsrivathsan on 8/7/2017.
 */
public class StringSearch {

    private static boolean isPatternExists( String inputText, String pattern) {

        for (int i = 0; i < inputText.length() - pattern.length() + 1; i++) {
            int j = 0;
            for (; j < pattern.length() && inputText.charAt(i+j) == pattern.charAt(j); j++) {
            }
            if (j == pattern.length()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPatternExists("srivathsan", "sri"));
        System.out.println(isPatternExists("srivathsan", "riv"));
        System.out.println(isPatternExists("srivathsan", "sdd"));
        System.out.println(isPatternExists("srivathsan", "thsan"));

    }
}
