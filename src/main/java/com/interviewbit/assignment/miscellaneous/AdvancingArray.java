import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 8/4/2017.
 */
public class AdvancingArray {

    public int canJump(ArrayList<Integer> numbers) {


        for (int i = 1; i < numbers.size(); i++) {
            int indexDifference = 0; boolean found = false;
            for (int j = i-1 ; j >= 0; j--) {
                indexDifference = i - j;
                if (numbers.get(j)  >= indexDifference) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {


    }
}
