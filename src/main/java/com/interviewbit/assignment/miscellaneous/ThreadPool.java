package com.caching;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by srivathsan on 01/04/16.
 */
public class ThreadPool {

    private WorkerThread[] threads = new WorkerThread[10];

    private Queue<Runnable> tasks = new ConcurrentLinkedQueue<Runnable>();

    public ThreadPool() {
        for (int i =0; i < 10; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
    }

    public void enqueue (Runnable r) {
        synchronized (tasks) {
            tasks.offer(r);
            tasks.notify();
        }
    }

    public class WorkerThread extends  Thread {
        public void run () {
            Runnable r = null;
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = tasks.poll();
                }
                try {
                    r.run();
                } catch (Exception e) {
                    // Ignore exceptions
                }
            }
        }
    }

    public static class NewRunnable implements Runnable {
        public void run() {
            System.out.println(Thread. currentThread().getName() + " *******");
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());
        threadPool.enqueue(new NewRunnable());


    }
}
