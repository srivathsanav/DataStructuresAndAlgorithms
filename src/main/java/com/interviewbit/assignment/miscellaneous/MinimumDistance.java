import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by avsrivathsan on 7/28/2017.
 */
public class MinimumDistance {

    private static int findMinimumDistance(List<String> words) {
        Map<String, Integer> wordIntegerDistanceMap = new HashMap<>();

        int i =0;
        int maxDistance = Integer.MAX_VALUE;
        for (String word : words) {
            if (wordIntegerDistanceMap.get(word) != null) {
                maxDistance = Math.min(maxDistance, i - wordIntegerDistanceMap.get(word));
            }
            wordIntegerDistanceMap.put(word, i);
            i++;
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumDistance(Arrays.asList("All", "work", "and", "no", "play", "makes", "for", "no", "work", "no","fun", "no", "results")));
    }
}
