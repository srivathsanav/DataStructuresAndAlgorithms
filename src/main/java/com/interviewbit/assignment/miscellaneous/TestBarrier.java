/**
 * Created by avsrivathsan on 6/7/2017.
 */

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by avsrivathsan on 6/7/2017.
 */
public  class TestBarrier {

    private CountDownLatch latch;

    private CyclicBarrier barrier;
    Map<String, Boolean> threadMap = new ConcurrentHashMap<>();

    public TestBarrier(int threadCount) {
        latch = new CountDownLatch(threadCount);
        barrier = new CyclicBarrier(threadCount);
    }

    public synchronized void critical() {

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (threadMap.get(Thread.currentThread().getName()) != null) {
            try {
                if (barrier.getParties() != 0) {
                    System.out.println("Waiting " + Thread.currentThread().getName());
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Critical method called" + " " + Thread.currentThread().getName());

        threadMap.put(Thread.currentThread().getName(), true);
        if (barrier.getParties() == 0) {
            threadMap.clear();
            // criticalLatch = new CountDownLatch(10);
        }
        notifyAll();
    }

    public void rendezvous() {
        //System.out.println("Rendezvous method called" + " " + Thread.currentThread().getName());
        latch.countDown();
    }



    public static class ThreadClient implements  Runnable {
        private TestBarrier testBarrier;

        public ThreadClient(TestBarrier example) {
            this.testBarrier = example;
        }


        public void run(){
            testBarrier.rendezvous();
            testBarrier.critical();
            testBarrier.critical();
            testBarrier.critical();
            testBarrier.critical();
            testBarrier.critical();

        }
    }



    public static void main(String[] args) {
        TestBarrier example = new TestBarrier(10);

        for (int i = 0; i < 10; i++) {
            ThreadClient threadClient = new ThreadClient(example);
            new Thread(threadClient).start();
        }

    }
}