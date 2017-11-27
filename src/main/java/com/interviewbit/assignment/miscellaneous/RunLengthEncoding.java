/**
 * Created by avsrivathsan on 8/8/2017.
 */
public class RunLengthEncoding {

    private static void runLengthEncoding(String input) {
        if (input.length() == 1) {
            System.out.println(input.concat("1"));
        }
        int currentCount = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i-1)) {
                currentCount++;
            } else {
                sb.append(input.charAt(i-1)).append(currentCount);
                currentCount = 1;
            }
        }
        sb.append(input.charAt(input.length()-1)).append(currentCount);
        System.out.println(sb.toString());
    }

    private static void decodeInput(String input) {
        StringBuilder sb = new StringBuilder();
        int currentCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                currentCount = input.charAt(i) - '0';
                System.out.println(currentCount);
            } else {
                for (int j = 0; j < currentCount; j++) {
                    sb.append(input.charAt(i));

                }
            }
        }
            System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        runLengthEncoding("anbbbcccddeeee");
        decodeInput("4a5b6c1d");
    }
}
