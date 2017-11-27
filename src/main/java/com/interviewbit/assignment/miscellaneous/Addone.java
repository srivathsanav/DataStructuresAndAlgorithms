import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 8/3/2017.
 */
public class Addone {

    private static void addOne(ArrayList<Integer> numbers) {
        int carry = 0;
        int sum = 0;

        for (int i = numbers.size() - 1 ; i >= 0; i--) {
            if ( i == numbers.size() -1 ) {
                sum = numbers.get(i) + 1;
            } else {
                sum = numbers.get(i) + carry;
            }

            carry = sum / 10;
            sum = sum % 10;
            numbers.set(i, sum);
        }

        if (carry == 1) {
            numbers.add(0, 1);
        }
        System.out.println(numbers);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(9, 9, 9, 9));
        addOne(numbers);
    }

}
