import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 8/31/2017.
 */
public class PowerSet {

    private static List<List<Integer>> generatePowerSets (List<Integer> inputSet) {
        List<List<Integer>> powerSets = new ArrayList<>();
        generatePowerSetsHelper(inputSet, powerSets, 0, new ArrayList<>());
        System.out.println(powerSets);
        return powerSets;
    }

    private static void generatePowerSetsHelper(List<Integer>integers, List<List<Integer>> powerSets, int n, List<Integer> currentSet) {
        if ( n == integers.size()) {
            powerSets.add(new ArrayList<>(currentSet));
            return;
        }
        currentSet.add(integers.get(n));
        generatePowerSetsHelper(integers, powerSets, n + 1, currentSet);
        currentSet.remove(currentSet.size() -1 );
        generatePowerSetsHelper(integers, powerSets, n + 1, currentSet);
    }

    public static void main(String[] args) {
        generatePowerSets(Arrays.asList(0,1,2));
    }
}
