import java.util.*;

/**
 * Created by avsrivathsan on 9/11/2017.
 */
public class PermutateNew {

    private static List<List<Integer>> permutate(int[] input) {
        Map<Integer, Integer> mapper = new HashMap<>();

        for (Integer ch : input) {
            int count = 1;
            if (mapper.get(ch) != null) {
                count = mapper.get(ch) + 1;
            }
            mapper.put(ch, count);
        }
        Integer[] inputArray = new Integer[mapper.size()];
        int[] countArray = new int[mapper.size()];
        int i = 0;
        for ( Map.Entry<Integer, Integer> mapperIter: mapper.entrySet()) {
            inputArray[i] = mapperIter.getKey();
            countArray[i] = mapperIter.getValue();
            i++;
        }
        return permutate(inputArray, countArray, new Integer[input.length], 0, new ArrayList<>());
    }

    private static List<List<Integer>> permutate(Integer[] input, int[] count, Integer[] temp, int level, List<List<Integer>> outputList) {
        if (level == temp.length) {
            outputList.add(Arrays.asList(Arrays.copyOf(temp, temp.length)));
        } else {
            for (int i = 0; i < input.length; i++) {
                if (count[i] == 0) {
                    continue;
                }
                count[i]--;
                temp[level] = input[i];
                permutate(input, count, temp, level + 1, outputList);
                count[i]++;
            }
        }
        return outputList;

    }

    public List<List<Integer>> permute(int[] nums) {
        return permutate(nums);
    }

    public static void main(String[] args) {
        int[] test = {1,1,1};

        System.out.println(permutate(test));
    }
}
