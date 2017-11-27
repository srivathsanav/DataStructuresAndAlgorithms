import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by avsrivathsan on 5/31/2017.
 */
public class CountDownLatchExample {

    private static void calculateTimeSpread(int concurrencyLeval, ExecutorService executor) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrencyLeval);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(concurrencyLeval);
            for (int i = 0; i < concurrencyLeval; i++) {
            executor.submit(() -> {
                        ready.countDown();
                        try {
                            start.await();
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                           ex.printStackTrace();
                        } finally {
                            end.countDown();
                        }
                    }
            );


        }

        ready.await();
        start.countDown();
        long startTime = System.nanoTime();
        end.await();
        System.out.println(System.nanoTime() - startTime);
        executor.shutdown();
    }

    public static void main(String[] args) {
        try {
            calculateTimeSpread(5, Executors.newFixedThreadPool(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
