import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by avsrivathsan on 8/22/2017.
 */
public class MatchWordsWithSentence {

    private List<Integer> matchWordsInSentence (final String sentence, final List<String> words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            increment(countMap, word);
        }

        int totalWords = words.size();
        int wordLength = words.get(0).length();
        for (int i = 0; i + wordLength* totalWords < sentence.length(); i++) {

        }
        return  null;
    }

    private boolean matchSubString(String sentence, List<String> words, int start, int end, int unitSize, Map<String, Integer> countMap) {
        Map<String, Integer> sentenceMap = new HashMap<>();

        for (int i = start; i + unitSize < end; i = i + unitSize) {
            String currSentence = sentence.substring(i, i+ unitSize);
            if (countMap.get(currSentence) == null) {
                return false;
            }
            increment(sentenceMap, currSentence);

        }
        return true;
    }


    private static void increment(Map<String, Integer> countMap, String word) {
        int count = 1;
        if (countMap.get(word) != null) {
            count = countMap.get(word) + 1;
        }
        countMap.put(word, count);
    }
}
