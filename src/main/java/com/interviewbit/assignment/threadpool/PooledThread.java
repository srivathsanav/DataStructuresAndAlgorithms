package threadpool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by avsrivathsan on 6/2/2017.
 */
public class PooledThread extends Thread{

    private static  boolean isStopped;

    private BlockingQueue<Task> task;

    public PooledThread(BlockingQueue<Task>  task) {
        this.task = task;
    }

    @Override
    public void run() {
        while (!isStopped) {
            try {
                task.take().run();
            } catch (InterruptedException ex) {
                ex.printStackTrace();;
            }
        }
    }

    public void stopThread() {
        isStopped = true;
    }
}
