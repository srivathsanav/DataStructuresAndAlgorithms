/**
 * Created by avsrivathsan on 8/8/2017.
 */
public class LookAndSay {

    private static String countAndSay(int n) {

        StringBuilder input = new StringBuilder("1");
        for (int i = 2; i <= n ; i++) {
            int currentCount = 1;
            StringBuilder output = new StringBuilder();
            for (int j = 1; j <= input.length(); j++ ) {
                if (j == input.length() || input.charAt(j) != input.charAt(j-1)) {
                    output.append(currentCount).append(input.charAt(j-1));
                    currentCount = 1;
                } else {
                    currentCount++;
                }
            }
            input = new StringBuilder(output);
        }
        return input.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
    }

}
