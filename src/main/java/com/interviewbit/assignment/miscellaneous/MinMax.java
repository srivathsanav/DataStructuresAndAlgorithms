import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 7/31/2017.
 */
public class MinMax {

    private static void mimMax(List<Integer> numbers) {
        int i = 0;
        int j = 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (i < numbers.size() - 1 && j < numbers.size()) {
            min = numbers.get(i) < numbers.get(j) ?  Math.min(min, numbers.get(i)) : Math.min(min, numbers.get(j));
            max = numbers.get(i) > numbers.get(j) ?  Math.max(max, numbers.get(i)) : Math.max(max, numbers.get(j));
            i = i + 2;
            j = j + 2;
        }

        System.out.println(min +  "  " + max);
    }

    public static void main(String[] args) {
        mimMax(Arrays.asList(3, 2, 5, 1, 2, 4, 7));
    }
}
