/**
 * Created by avsrivathsan on 12/29/2016.
 */
public class ThreeSum {

    public static void findThreeSum(Integer[] args, final int finalSum) {

        for (int i = 0; i < args.length; i++) {
            int k = args.length - 1;
            for (int j = i + 1; k > 0 && j < args.length; ) {
                if (args[j] + args[k] == (finalSum - args[i])) {
                    System.out.println(args[i] + " " + args[j] + " " + args[k]);
                    return;
                } else if (args[j] + args[k] > (finalSum - i)) {
                    k--;
                } else {
                    j++;
                }
            }
        }

    }

    public static void main(String[] args) {
        findThreeSum(new Integer[]{1, 2}, -1);
    }
}
