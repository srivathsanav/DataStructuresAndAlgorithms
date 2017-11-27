import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/6/17.
 */
public class Fibonacci {

    private static BigInteger getFibonacci (int number, BigInteger[] fib) {
        if (number <= 0) {
            return BigInteger.ZERO;
        }else if (number <= 2) {
            return BigInteger.ONE;
        }
        if (fib[number] != null) {
            return fib[number];
        } else {
                fib[number] = getFibonacci(number - 1, fib).add( getFibonacci(number - 2, fib));
                return fib[number];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String myInt= "";
        BigInteger fib[] = new BigInteger[101];

        do {
             myInt = scanner.nextLine();
            if (!myInt.isEmpty()) {
                int N = Integer.parseInt(myInt);

                System.out.println(getFibonacci(N, fib));
            }
           // System.out.println();
        } while (!myInt.isEmpty());


    }
}
