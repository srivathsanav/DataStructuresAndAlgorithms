import java.util.*;

/**
 * Created by avsrivathsan on 7/28/2017.
 */
public class Anagrams {


    private static void printAnagrams (List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);
            if (anagramMap.get(sortedWord) == null) {
                anagramMap.put(sortedWord, new ArrayList<>());
            }
            anagramMap.get(sortedWord).add(word);
        }

        for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void main(String[] args) {

        printAnagrams(Arrays.asList("debitcard", "badcredit", "money", "silent", "listen"));
    }
}
