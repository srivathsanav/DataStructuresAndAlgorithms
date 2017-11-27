import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by avsrivathsan on 6/20/2017.
 */
public class FBThreadExample {

    public static void main(String[] args) {
        int n = 20;

         Thread[] threads = {
                 new FBThread(i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz", n),
                 new FBThread(i -> i % 3 == 0 && i % 5 ==0 , i -> "FizzBuzz", n),

                 new FBThread(i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz", n),
                 new FBThread(i -> i % 3 != 0 && i % 5 != 0, i -> Integer.toString(i), n)};
                 for (Thread thread : threads) {
             thread.start();
             }
    }
}

     class FBThread extends Thread {
        private  Object lock = new Object();
        protected  int current = 1;
        private int max;
        private Predicate<Integer> validate;
        private Function<Integer, String> printer;
        int x = 1;

        public FBThread(Predicate<Integer> validate,
                        Function<Integer, String> printer, int max) {
            this.validate = validate;
            this.printer = printer;
            this.max = max;
        }

        public void run() {
            while (true) {
                synchronized (lock) {
                    if (current > max) {
                        return;
                    }
                    if (validate.test(current)) {
                        System.out.println(printer.apply(current));
                    }
                    current++;
                }
            }
        }
    }
