import java.util.*;

/**
 * Created by srivathsan on 10/7/17.
 */
public class Stones {

    private static void findStones(List<Integer> input,  int currLength,List<List<Integer>> result, List<Integer> buffer, int combinationLength) {
        if (currLength == combinationLength) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            int value = (buffer.size() > 0 ? buffer.get(buffer.size()-1) + input.get(i) : input.get(i));
            buffer.add(value);
            findStones(input, currLength+1, result, buffer, combinationLength);
            buffer.remove(buffer.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++) {
            int combinationLength = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            /*List<List<Integer>> result = new ArrayList<>();
            List<Integer> input = Arrays.asList(a, b);
            List<Integer> buffer = new ArrayList<>();
            buffer.add(0);
            findStones(input, 0, result, buffer, combinationLength-1);
            Set<Integer> set = new LinkedHashSet<>();
            for (List<Integer> values : result) {
                set.add(values.get(values.size()-1));
            }
            for (int value : set) {
                System.out.print(value+ " ");
            }
            System.out.println();*/
            Set<Integer> set = new LinkedHashSet<>();

            List<Integer> result = new ArrayList<>();
            result.add(a*(combinationLength-1));
            for (int i = 1; i <=combinationLength-1; i++) {
                for (int j = 1; j <= combinationLength-1; j++) {
                    if ( i+ j == combinationLength-1) {
                        int value = i * b + j * a;
                        result.add(value);
                    }
                }
            }


            result.add(b* (combinationLength-1));
            Collections.sort(result);
            set.addAll(result);
            for (int value : set) {
                System.out.print(value+ " ");
            }
            System.out.println();
        }
    }
}
