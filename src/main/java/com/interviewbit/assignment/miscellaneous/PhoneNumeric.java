import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by avsrivathsan on 8/8/2017.
 */
public class PhoneNumeric {

    public static void computeNumeric(Map<Integer, String> keyMap, List<String> finalList, char[] current, String input, int currInputIndex) {

        if (currInputIndex == input.length()) {
            finalList.add(new String(current));
            System.out.println(finalList);
        } else {
            for (int i = 0; i <  keyMap.get(input.charAt(currInputIndex) - '0').length(); i++) {
                current[currInputIndex] = keyMap.get(input.charAt(currInputIndex) - '0').charAt(i);
                computeNumeric(keyMap, finalList, current, input, currInputIndex + 1);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> keyMap = new HashMap<>();
        keyMap.put(2, "ABC");

        keyMap.put(2, "ABC");
        keyMap.put(3, "DEF");
        keyMap.put(4, "GHI");
        keyMap.put(5, "JKL");
        keyMap.put(6, "MNO");
        keyMap.put(7, "PQRS");
        keyMap.put(8, "TUV");
        keyMap.put(9, "WXYZ");
        List<String> finalList = new ArrayList<>();
        String input = "22";
        computeNumeric(keyMap, finalList, new char[input.length()], input, 0);
        System.out.println(finalList);
    }
}
