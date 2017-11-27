import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by avsrivathsan on 7/31/2017.
 */
public class PowerFunction {



        public static long pow(int a, int n, int d) {
            if ( n == 0 ) {
                return 1%d;
            }
            long ans = 1; long base = a;

            while ( n > 0) {
                if (n%2 == 0) {
                    base = (base * base) % d;
                    n = n/2;
                } else {
                    ans = (ans * base)%d;
                    n--;
                }
            }
            System.out.println(ans);
            if (ans < 0) {
                ans = (ans + d) % d;
            }
            return ans;
    }




    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        Collections.rotate(test, -1);
        System.out.println(test);
        Collections.rotate(test, 2);
        System.out.println(test);


    }

}
