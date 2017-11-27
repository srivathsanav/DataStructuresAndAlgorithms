/**
 * Created by avsrivathsan on 8/9/2017.
 */
public class BaseConversion {

    private static void baseConversion(int input, int base1) {
        StringBuilder output = new StringBuilder();
        while (input >= base1 ) {
            int remainder = input % base1;
            output.insert(0, (char) (remainder >= 10 ? (char) (remainder - 10 + 'A')  : '0' + remainder));
            input = input /base1;
        }
        output.insert(0, input > 10 ? (char) (input - 'A') + (input - 10) : input);

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        baseConversion(100, 16);
    }
}
