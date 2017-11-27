package threadpool;

/**
 * Created by avsrivathsan on 6/2/2017.
 */
public class Task1 extends Task {

    @Override
    public void run() {
        System.out.println("Task 1 is running " + " " + Thread.currentThread().getName());
    }
}
