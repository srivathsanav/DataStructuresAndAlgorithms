import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class DiscreteMathsProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }

            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    k--;
                    if (k <= 0) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (k > 0) {
                System.out.println("YES");
            }
        }

    }
}
