import java.util.HashMap;
import java.util.Map;

/**
 * Created by avsrivathsan on 6/19/2017.
 */
public class Permutation {

    public static void main(String[] args) {
        String input = "AABC";

        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (Character character : input.toCharArray()) {
            if (characterCountMap.get(character) == null) {
                characterCountMap.put(character, new Integer(1));
            } else {
                characterCountMap.put(character, characterCountMap.get(character) + 1);
            }
        }

        char[] charArray = new char[characterCountMap.size()];
        int[] countArray = new int[characterCountMap.size()];
        int count = 0;
        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            charArray[count] = entry.getKey();
            countArray[count] = entry.getValue();
            count++;
        }

        printPermuatation( charArray, countArray, 0, new char[input.length()]);
    }

    private static void printPermuatation(  char[] charArray, int[] countArray, int index, char[] buffer) {
        if (buffer.length == index) {
            System.out.println(buffer);
            return;
        }
        for (int i = 0 ; i < charArray.length; i++) {
            if (countArray[i] == 0 ) {
                continue;
            }
            buffer[index] = charArray[i];
            countArray[i]--;
            printPermuatation(charArray, countArray, index + 1, buffer);
            countArray[i]++;
        }
    }
}
