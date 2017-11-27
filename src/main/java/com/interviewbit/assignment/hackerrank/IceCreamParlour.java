import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class IceCreamParlour {

    private static void spendMoney(int moneyAvailable, int[] cost) {
        IceCream iceCreams[] = new IceCream[cost.length];
        for (int i = 0; i < cost.length; i++) {
            IceCream iceCream = new IceCream(i+1, cost[i]);
            iceCreams[i] = iceCream;
        }
        Arrays.sort(iceCreams);
        int i = 0, j = iceCreams.length - 1;
        while (i < j) {
            long sum = iceCreams[i].cost + iceCreams[j].cost;
            if (sum == moneyAvailable) {
                int minimum = Math.min(iceCreams[i].index, iceCreams[j].index);
                int maximum = Math.max(iceCreams[i].index, iceCreams[j].index);
                System.out.println(minimum + " " + maximum);
                return;
            } else if (sum > moneyAvailable) {
                j--;
            } else {
                i++;
            }
        }

    }

    static class IceCream implements Comparable<IceCream> {
         int index;
         int cost;

        public IceCream(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(IceCream o) {
            int diffValueIncost = Integer.compare(cost, o.cost);
            if (diffValueIncost != 0) {
                return diffValueIncost;
            } else {
                int diffInIndex = Integer.compare(index, o.index);
                return diffInIndex;
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i=0; i < N; i++){
            int moneyAvailable = in.nextInt();
            int number = in.nextInt();
            int[] cost = new int[number];
            for (int j = 0; j < number; j++) {
                cost[j] = in.nextInt();
            }
            spendMoney(moneyAvailable, cost);
        }
    }
}
