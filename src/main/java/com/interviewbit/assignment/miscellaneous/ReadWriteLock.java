import java.util.HashMap;
import java.util.Map;

/**
 * Created by avsrivathsan on 6/21/2017.
 */
public class ReadWriteLock {

    private int readers = 0;

    private int writeRequests = 0;

    Map<Thread, Integer> threadAccessCountMap = new HashMap<>();

    private Thread writerThread = null;

    private int writeAccessCount = 0;


    public synchronized void lockRead() throws InterruptedException {
        while (!canGiveReadAccess()) {
            wait();
        }
        threadAccessCountMap.put(Thread.currentThread(), threadAccessCountMap.get(Thread.currentThread())+ 1);
    }

    private boolean canGiveReadAccess() {
        if (writeAccessCount > 0) {
            return false;
        }
        Thread currentThread = Thread.currentThread();
        if (threadAccessCountMap.get(currentThread) != null) {
            return true;
        }
        if (writeAccessCount > 0) {
            return false;
        }
        return true;
    }

    public synchronized void unlockRead() throws InterruptedException {
       if (threadAccessCountMap.get(Thread.currentThread()) == 1 ) {
           threadAccessCountMap.remove(Thread.currentThread());
       } else {
           threadAccessCountMap.put(Thread.currentThread(), threadAccessCountMap.get(Thread.currentThread())- 1);
       }
       notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        // If current thread is writer, increment write access count
        // else increment write requests
        //
        writeRequests++;
        while(!canGiveWriteAccess()) {
            wait();
        }
        writeRequests--;
        writeAccessCount++;
        writerThread =  Thread.currentThread();
    }

    public synchronized void unLockWrite() throws InterruptedException {
        writeAccessCount--;
        notifyAll();
    }

    private boolean canGiveWriteAccess() {
        if (threadAccessCountMap.size() > 0) {
            return false;
        }
        if (writerThread == null) {
            return true;
        }
        if (Thread.currentThread() != writerThread) {
            return false;
        }

        return true;
    }



}
