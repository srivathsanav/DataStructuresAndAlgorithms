import java.util.Arrays;
import java.util.List;

/**
 * Created by avsrivathsan on 9/1/2017.
 */
public class MaxSubArraySum {

    public static int maxSubArray(List<Integer> integers) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < integers.size(); i++) {
            currentSum = currentSum + integers.get(i);
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(Arrays.asList(-2,1,-3,4,-1,2,1,-5,4)
        ));
    }

    public int maxSubArray1(final List<Integer> a) {




        int currentSum = 0; int answer = Integer.MIN_VALUE;

        for (int i = 0; i < a.size(); i++) {


            currentSum = a.get(i) + currentSum;

            answer = Math.max(answer, currentSum);
            if (currentSum < 0)
                currentSum = 0;
        }
        return answer;
    }
}
