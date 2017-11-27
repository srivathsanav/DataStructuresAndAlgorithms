/**
 * Created by avsrivathsan on 8/9/2017.
 */
public class ReverseWords {

    private static void reverseWords(char[] inputWord) {
        reverseWord(inputWord, 0, inputWord.length -1);
        int start = 0;
        int end = 0;
        while ((end = findCharacter(inputWord, ' ', start)) != -1) {
            reverseWord(inputWord, start, end - 1);
            start = end + 1;
        }
        reverseWord(inputWord, start, inputWord.length - 1);

    }

    private static void reverseWord(char[] input, int start, int end) {
        for (int i = start; i <= (start+ end) /2 ; i++) {
            char temp = input[i];
            input[i] = input[end -i + start];
            input[end - i + start] = temp;
        }
    }

    private static int findCharacter(char[] input, char ch, int start) {
        for (int i = start; i < input.length; i++) {
            if (input[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] ch = "ram is costly".toCharArray();
        reverseWords(ch);
        System.out.println(ch);
    }
}
