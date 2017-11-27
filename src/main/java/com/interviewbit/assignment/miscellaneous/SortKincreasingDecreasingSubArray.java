import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by avsrivathsan on 7/29/2017.
 */
public class SortKincreasingDecreasingSubArray {
    enum SubArrayType {
        INCREASING,
        DECREASING
    }


    private static void sortKincreasingDecreasingSubArray(List<Integer> numbers) {
        SubArrayType subArrayType = SubArrayType.INCREASING;

        int subArrayIndex = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (i == numbers.size() -1 ||
                    (numbers.get(i-1) > numbers.get(i) && subArrayType ==SubArrayType.INCREASING)
                    || (numbers.get(i-1) < numbers.get(i) && subArrayType ==SubArrayType.DECREASING)
                       ) {
                List<Integer> subList = i == numbers.size() -1 ? numbers.subList(subArrayIndex, i + 1) : numbers.subList(subArrayIndex, i);


                if (subArrayType == subArrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                System.out.println(subList);

                subArrayIndex = i;

                subArrayType = subArrayType == SubArrayType.INCREASING ? SubArrayType.DECREASING : SubArrayType.INCREASING;
            }
        }

    }

    public static void main(String[] args) {
        sortKincreasingDecreasingSubArray(Arrays.asList(57, 131, 493, 294, 221, 339, 418, 452, 442, 190));
    }
}
