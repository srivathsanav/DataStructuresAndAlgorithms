/**
 * Created by avsrivathsan on 6/7/2017.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by avsrivathsan on 6/7/2017.
 */
public  class RendezvousCriticalExample {

    private CountDownLatch latch;

    private CountDownLatch criticalLatch;
    Map<String, Boolean> threadMap = new ConcurrentHashMap<>();

    public RendezvousCriticalExample(int threadCount) {
        latch = new CountDownLatch(threadCount);
        criticalLatch = new CountDownLatch(threadCount);
    }

    public synchronized void critical() {

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (threadMap.get(Thread.currentThread().getName()) != null) {
            try {
                if (criticalLatch.getCount() != 0) {
                    System.out.println("Waiting " + Thread.currentThread().getName());
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Critical method called" + " " + Thread.currentThread().getName());
        criticalLatch.countDown();
        threadMap.put(Thread.currentThread().getName(), true);
        if (criticalLatch.getCount() == 0) {
            threadMap.clear();
            criticalLatch = new CountDownLatch(10);
        }
        notifyAll();
    }

    public void rendezvous() {
        //System.out.println("Rendezvous method called" + " " + Thread.currentThread().getName());
        latch.countDown();
    }



    public static class ThreadClient implements  Runnable {
        private RendezvousCriticalExample rendezvousCriticalExample;

        public ThreadClient(RendezvousCriticalExample example) {
            this.rendezvousCriticalExample = example;
        }


        public void run(){
            rendezvousCriticalExample.rendezvous();
            rendezvousCriticalExample.critical();
            rendezvousCriticalExample.critical();
            rendezvousCriticalExample.critical();
            rendezvousCriticalExample.critical();
            rendezvousCriticalExample.critical();

        }
    }



    public static void main(String[] args) {
        RendezvousCriticalExample example = new RendezvousCriticalExample(10);

        for (int i = 0; i < 10; i++) {
            ThreadClient threadClient = new ThreadClient(example);
            new Thread(threadClient).start();
        }

    }
}