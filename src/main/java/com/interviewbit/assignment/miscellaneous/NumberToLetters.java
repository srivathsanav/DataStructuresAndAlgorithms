package com.datastructures;

/**
 * Created by srivathsan on 07/03/17.
 */
public class NumberToLetters {

    private static String numberToLetters(int value) {
        char[] alphabetArray = {'Z' , 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuffer letter = new StringBuffer();
        while (value > 0) {
            int remainder  = value%26;
            value = (remainder == 0) ?  value = value - 1 : value;
            letter.append(alphabetArray[remainder]);
            value = value/26;
        }
        return letter.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(numberToLetters(53));
    }
}
