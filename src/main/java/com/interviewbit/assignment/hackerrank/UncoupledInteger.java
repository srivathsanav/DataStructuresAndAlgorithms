import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srivathsan on 10/6/17.
 */
public class UncoupledInteger {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input[] = line.trim().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String val : input) {
            numbers.add(Integer.valueOf(val.trim()));
        }
        uncoupledInteger(numbers);
    }

    private static void uncoupledInteger(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result = result ^ number;
        }
        System.out.println(result);
    }
}
