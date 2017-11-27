package com.datastructures;


import java.util.concurrent.Semaphore;

/*
   This program prints numbers from 1 to N using M threads.
   Thread i prints number X, and Thread i+1 prints number X + 1 etc
   When N = M, each thread prints number only once
 */
public class PrintNumbersUsingNThreads {


    public static int howManyNumbersToPrint = 0;

    public static int numberOfThreads = 0;

    /* Thread number*/
    private int threadNum = 0;

    private Semaphore semaphores[];

    /* This is used to print values*/
    private  int count ;


    public PrintNumbersUsingNThreads(int threadNum, Semaphore[] semaphores) {
        this.threadNum = threadNum;
        this.semaphores = semaphores;
        this.count = threadNum;
    }

    public void print() {
        try {
            semaphores[threadNum].acquire();
            System.out.println(" Number is " + count +  " printed by  " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            count+= numberOfThreads;
            System.out.println(count);
            semaphores[(threadNum + 1)%numberOfThreads].release();
        }
    }


    public static void main(String[] args) {
        // Initialize how many numbers to be printed
        PrintNumbersUsingNThreads.howManyNumbersToPrint = 20;
        // Initialize number of threads to spawn
        PrintNumbersUsingNThreads.numberOfThreads = 10;

        // Initialize first thread with permit 1
        Semaphore[] semaphores = new Semaphore[numberOfThreads];
        Semaphore semaphore = new Semaphore(1);
        semaphores[0] = semaphore;

        // Initialize other threads with permit 0
        for (int i =1 ; i < numberOfThreads; i++) {
            Semaphore iThSemaphore = new Semaphore(0);
            semaphores[i] = iThSemaphore;
        }

        // Start the threads
        for (int i = 0; i < numberOfThreads; i++) {
            PrintNumbersUsingNThreads instance = new PrintNumbersUsingNThreads(i, semaphores);
            RunnerThread thread = new RunnerThread(instance);
            thread.start();
        }

    }


    static class RunnerThread extends Thread {
        private PrintNumbersUsingNThreads printOddAndEven;

        public RunnerThread(PrintNumbersUsingNThreads printOddAndEven) {
            this.printOddAndEven = printOddAndEven;
        }

        public void run() {
            while (printOddAndEven.count <= howManyNumbersToPrint) {
                printOddAndEven.print();
            }
        }
    }
}
