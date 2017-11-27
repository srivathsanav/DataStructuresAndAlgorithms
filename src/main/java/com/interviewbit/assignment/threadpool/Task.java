package threadpool;

/**
 * Created by avsrivathsan on 6/2/2017.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Main task is running " + " " + Thread.currentThread().getName());
    }
}
