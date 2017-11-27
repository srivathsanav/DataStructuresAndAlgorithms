import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class HappyLadybugs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            happyLadybugs(b);
        }
    }

    private static void happyLadybugs(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            //System.out.println(input + "    " + currentChar + "  " + i);
             if (!isCurrentCharOk(input, i))   {
                for (int j = 0; j < input.length(); j++) {
                        if (input.charAt(j) == '_' && ((j > 0 && input.charAt(j-1) == input.charAt(i) && i != j-1))) {

                            char[] tempString = input.toCharArray();
                            char temp = tempString[i];
                            tempString[i] = tempString[j];
                            tempString[j] = temp;
                            input = new String(tempString);
                            i = -1;
                            break;
                        } else if (  input.charAt(j) == '_' && (j < (input.length() -1) && input.charAt(j+1) == input.charAt(i) && i != j+1)) {

                            char[] tempString = input.toCharArray();
                            char temp = tempString[i];
                            tempString[i] = tempString[j];
                            tempString[j] = temp;
                            input = new String(tempString);
                            i = -1;
                            break;
                        }

                }
            }
        }
      //  System.out.println(input);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!isCurrentCharOk (input, i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static  boolean isCurrentCharOk(String input, int i) {
        char currentChar = input.charAt(i);
        if (currentChar == '_') {
            return true;
        }
        if ( (i > 0 && currentChar == input.charAt(i-1)) ||
                (i < (input.length() - 1) && currentChar == input.charAt(i+1))) {
            return true;
        }
        return false;
    }
}
