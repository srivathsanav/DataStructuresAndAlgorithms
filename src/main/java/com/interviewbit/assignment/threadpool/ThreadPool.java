package com.interviewbit.assignment.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by avsrivathsan on 6/2/2017.
 */
public class ThreadPool {
    private BlockingQueue<Task> tasks;

    private List<PooledThread> threads = new ArrayList<>();

    private int noOfThreads;

    public ThreadPool(int maxThreads, int taskSize) {
        this.noOfThreads = maxThreads;
        tasks = new ArrayBlockingQueue<Task>(taskSize);
        for (int i = 0; i < maxThreads; i++) {
            PooledThread thread = new PooledThread(tasks);
            threads.add(thread);
        }

        for (int i = 0; i < maxThreads; i++) {
            threads.get(i).start();
        }
    }

    public void submit(Task task) {
        tasks.add(task);
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task task = new Task();

        ThreadPool tp = new ThreadPool(10, 10);
        int count = 0;
        try {
            while (count < 50) {
                tp.submit(task);
                Thread.sleep(50);
                tp.submit(task1);
                Thread.sleep(50);
                tp.submit(task2);
                Thread.sleep(50);
                count++;
            }
        } catch (InterruptedException ex) {

        }
    }


}
