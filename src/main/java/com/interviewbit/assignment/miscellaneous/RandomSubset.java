import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by avsrivathsan on 8/7/2017.
 */
public class RandomSubset {

    private static List<Integer> generateRandomSubset(List<Integer> input, int k) {
        Random rand = new Random();
        //Boundry checks
        for (int i = 0; i < k; i++ ) {
            int number = rand.nextInt(input.size() - i) + i;
            System.out.println(number);
            int temp = input.get(number);
            input.set(number, input.get(i));
            input.set(i, temp);
        }
        return input.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(generateRandomSubset(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 4));
    }
}
