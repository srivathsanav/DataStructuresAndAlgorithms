import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by srivathsan on 10/6/17.
 */
public class Factorial {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int N = Integer.parseInt(line);
        fact(N);
    }

   private static void fact(int n) {
       BigInteger fact = BigInteger.ONE;

       for (int i = 1; i <= n; i++) {
           fact = fact.multiply(BigInteger.valueOf(i));
       }
       System.out.println(fact);
   }
}
