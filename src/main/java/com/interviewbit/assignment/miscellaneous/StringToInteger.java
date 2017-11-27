/**
 * Created by avsrivathsan on 8/7/2017.
 */
public class StringToInteger {

    private static int convertStringToInt(String input) {
        boolean isNegative = false;
        int base = 10;
        double finalSum = 0;

        if (input.charAt(0) == '-') {
            isNegative = true;
        }
        int count = 0;
        for (int i = input.length() - 1; i >=0; i-- ) {

            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                finalSum = finalSum * 10  + (input.charAt(i) - '0');
            }
        }
        return (int) (isNegative ? -finalSum : finalSum);
    }

    private static final String intToString(int number) {
        StringBuilder finalStr = new StringBuilder();

        while (number > 0) {
            finalStr.append( (char) ('0' + Math.abs(number%10)));
            System.out.println(finalStr);
            number = number/10;
        }
        finalStr.reverse();
        return finalStr.toString();

    }

    public static void main(String[] args) {

        System.out.println(intToString(123));
    }
}
