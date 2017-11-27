import java.util.*;

/**
 * Created by srivathsan on 10/9/17.
 */
public class LeaderBoard {

    public static void main(String[] args) {
       /* List<Integer> list = Arrays.asList(100, 100, 50,   40, 40, 20, 10);
        System.out.println(Collections.binarySearch(list, 5, Collections.reverseOrder()));
        System.out.println(Collections.binarySearch(list, 120, Collections.reverseOrder()));
        System.out.println(Collections.binarySearch(list, 90, Collections.reverseOrder()));
        System.out.println(Collections.binarySearch(list, 120, Collections.reverseOrder()));*/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] scores = new Integer[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        printAliceRank(Arrays.asList(scores), alice, n);
    }

    private static void printAliceRank(List<Integer> input, int scores[], int n) {
        //Populate array containing rank
        int[] rank = new int[n];

        int currentRank = 1;
        rank[0] = currentRank;
        for (int i = 1; i < n; i++) {
            if (!input.get(i).equals(input.get(i-1))) {
                currentRank++;
            }
            rank[i] = currentRank;
        }
        int pointer = input.size() -1;
        for (int i = 0 ; i < scores.length; i++) {
            int aliceScore = scores[i];

            while (pointer >= 0 && aliceScore > input.get(pointer)) {
                pointer--;
            }
            currentRank = 0;
            if (pointer == -1) {
                currentRank = 1;
            } else if (aliceScore == input.get(pointer)) {
                currentRank = rank[pointer];
            } else if (aliceScore < input.get(pointer)) {
                currentRank = rank[pointer] + 1;
            }
            System.out.println(currentRank);
        }
    }

}
