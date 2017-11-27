import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 9/11/2017.
 */
public class Permutate1 {

    private static void permutate(List<Integer> inputArray, List<Integer> current, int currentElement) {

        if (currentElement == inputArray.size() -1) {
            System.out.println(inputArray);
        } else {
            current.add(inputArray.get(currentElement));
            permutate(inputArray, current, currentElement+1);
            current.remove(current.size()-1);
        }

    }

    public static void main(String[] args) {
        permutate(Arrays.asList(1, 2, 3, 4), new ArrayList<>(), 0);
    }
}
