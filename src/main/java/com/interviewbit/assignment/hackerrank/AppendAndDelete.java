import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class AppendAndDelete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        printAppendAndDeleteIsPossible(s, t, k);
    }

    private static void printAppendAndDeleteIsPossible(String s, String t, int k) {
        int i = 0, j = 0;
        if (s.equals(t) && k == 0) {
            System.out.println("Yes");
            return;
        }
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        int sDiff = s.length() - i;
        int tDiff = t.length() - j;
        int diffNeeded = 0;
        int overAllDiff = Math.abs(sDiff - tDiff);

        if (sDiff == 0 && tDiff == 0) {
            if (k > s.length()+t.length()) {
                System.out.println("Yes");
            } else if(isOddEvenPossible(k, overAllDiff)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            return;
        } else {
            diffNeeded = sDiff + tDiff;
        }
        if (diffNeeded <= k && (k >= (s.length()+t.length()) || isOddEvenPossible(k, overAllDiff))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isOddEvenPossible(int k, int overAllDiff) {

        if (overAllDiff%2 == 0 && k%2 == 0) {
            return true;
        } else if (overAllDiff%2 != 0 && k%2 != 0) {
            return true;
        }
        return false;
    }
}
