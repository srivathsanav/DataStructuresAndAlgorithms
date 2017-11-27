/**
 * Created by avsrivathsan on 8/8/2017.
 */
public class RabinKarp {

    private static int patternMatch(String text, String searchString) {
        int n = text.length();
        int m = searchString.length();

        if (m > n) {
            return -1;
        }

        int BASE = 10;
        long sHash = 0, tHash = 0;
        long powerS = 1;
        for (int i = 0; i < searchString.length(); i++) {
            powerS = (i > 0 ) ? powerS *BASE : 1;
            sHash =  sHash * BASE + searchString.charAt(i);
            tHash =  tHash *  BASE + text.charAt(i);
        }
        for (int i = searchString.length(); i < text.length(); i++) {
            if (tHash == sHash) {
                if (text.substring(i - searchString.length(), i).equals(searchString)) {
                    return i - searchString.length();
                }
            }
            tHash = tHash - (powerS * text.charAt(i-searchString.length()));
            tHash = tHash *BASE + text.charAt(i);
        }

        if (tHash == sHash && text.substring(text.length() - searchString.length()).equals(searchString)) {
            return text.length() - searchString.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(patternMatch("abc", "abc"));
    }

}
