import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class TarunBirthday {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            long price = Long.MIN_VALUE;
            if (z < x || z < y) {
                if ((y + z) < x) {
                    price = (y * w + (y + z) * b);
                } else if ((x + z) < y) {
                    price = (b * x + (x+z) * w);
                }
            }
            price = price == Long.MIN_VALUE ?  b * x + w * y : price;

            System.out.println(price);
        }
    }
}
