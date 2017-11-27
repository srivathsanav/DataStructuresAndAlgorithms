import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by avsrivathsan on 7/19/2017.
 */
public class LambdaExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( 3,  5);
        numbers.stream()
                .peek(x -> System.out.println(" from stream : " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println(" after map " + x))
                .filter(x -> x %2 == 0)
                .peek(x -> System.out.println(" after filter : " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit "+ x)).sorted(Comparator.reverseOrder())
                .peek(x -> System.out.println("after sorted "+ x))
                .collect(Collectors.toList());
    }
}
