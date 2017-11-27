import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class KangarooJump {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        if (x1 == x2) {
            return "YES";
        } else if (x1 > x2 && v1 >= v2) {
            return "NO";
        } else if (x2 > x1 && v2 >= v1) {
            return "NO";
        }
        for (long i = x1, j = x2; i <= Integer.MAX_VALUE && j <= Integer.MAX_VALUE ; i = i+ v1, j = j+ v2 ) {
                if (i == j) {
                    return "YES";
                }
        }
        return "NO";

    }
}
