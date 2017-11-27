import java.util.HashMap;
import java.util.Map;

/**
 * Created by avsrivathsan on 9/6/2017.
 */
public class ReaderWritersLock {

    private int writeRequestAccess;

    private Map<Thread, Integer> readerThreads = new HashMap<>();

    private Thread currentWritingThread;

    private int writeAccess;

    public void lockRead(){
        while (canRead()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readerThreads.put(Thread.currentThread(), getAccessCount()+1);
    }

    private  Integer getAccessCount() {
        if (readerThreads.get(Thread.currentThread()) != null) {
            return readerThreads.get(Thread.currentThread());
        }else {
            return 0;
        }
    }

    private boolean canRead() {
        if (currentWritingThread == Thread.currentThread()) {
            return true;
        }
        if (currentWritingThread != null) {
            return false;
        }

        if (readerThreads.get(Thread.currentThread()) != null) {
            return true;
        }

        if (writeRequestAccess > 0 ) {
            return false;
        }
        return true;
    }

    public void unlockRead() {
        if (getAccessCount() == 1) {
            readerThreads.remove(Thread.currentThread());
        } else {
            readerThreads.put(Thread.currentThread(), getAccessCount() - 1);
        }
        notifyAll();
    }

    private boolean canWrite() {
        if (readerThreads.size() > 1) {
            return false;
        }

        if (readerThreads.size() == 1 && readerThreads.get(Thread.currentThread()) == null) {
          return false;
        }

        if (currentWritingThread == null || Thread.currentThread() == currentWritingThread) {
            return true;
        }
        return true;
    }

    public void lockWrite() {
        writeRequestAccess++;
        while (canWrite()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeRequestAccess--;
        writeAccess++;
        currentWritingThread = Thread.currentThread();
    }

    public void unlockWrite() {
        writeAccess--;
        if (writeAccess == 0) {
            currentWritingThread = null;
        }
        notifyAll();
    }
}
