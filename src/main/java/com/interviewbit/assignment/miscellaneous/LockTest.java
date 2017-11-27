import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by avsrivathsan on 7/6/2017.
 */
public class LockTest {

    private Lock lock = new ReentrantLock();

    private void doOne() {
        lock.lock();
        try {
            int i = 0;
            while (i++ < 100) {
                System.out.println("one");
            }
        } finally {
           // lock.unlock();
        }
    }

    private void doTwo() {
        lock.lock();
        try {
            int i = 0;
            while (i++ < 100) {
                System.out.println("two");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.doOne();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.doTwo();
            }
        });

        t1.start();
        t2.start();
    }

}
