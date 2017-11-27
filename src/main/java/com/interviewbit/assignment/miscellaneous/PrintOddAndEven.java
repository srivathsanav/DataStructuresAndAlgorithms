package com;

import java.util.concurrent.Semaphore;

/**
 * Created by srivathsan on 15/04/16.
 */
public class PrintOddAndEven {


    private int number;

    private Semaphore oddSemaphore;

    private Semaphore evenSemaphore ;

    private boolean isOdd = false;

    public  PrintOddAndEven(int number, Semaphore semaphore1, Semaphore semaphore2 ) {
        this.number = number;

        if (number % 2 != 0) {
            this.isOdd = true;
            this.oddSemaphore = semaphore1;
            this.evenSemaphore = semaphore2;
        } else {
            this.oddSemaphore = semaphore2;
            this.evenSemaphore = semaphore1;
        }
    }

    public void print() {

            if (isOdd) {
                try {
                    oddSemaphore.acquire();
                    System.out.println(number + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    evenSemaphore.release();

                }
            } else {
                try {
                    evenSemaphore.acquire();
                    System.out.println(number + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    oddSemaphore.release();
                }
            }
            number += 2;

    }




    public static void main(String[] args) {
        Semaphore oddSemaphore = new Semaphore(1);
        Semaphore evenSemaPhore = new Semaphore(0);
        PrintOddAndEven odd = new PrintOddAndEven(1, oddSemaphore, evenSemaPhore);
        PrintOddAndEven even = new PrintOddAndEven(2, evenSemaPhore, oddSemaphore);
        RunnerThread oddThread = new RunnerThread(odd);
        RunnerThread evenThread = new RunnerThread(even);
        evenThread.start();
        oddThread.start();

    }


   static class RunnerThread extends Thread {
        private PrintOddAndEven printOddAndEven;

        public  RunnerThread(PrintOddAndEven printOddAndEven) {
            this.printOddAndEven = printOddAndEven;
        }

        public void run() {
            while (printOddAndEven.number <= 20) {
                printOddAndEven.print();
            }
        }
    }
}
