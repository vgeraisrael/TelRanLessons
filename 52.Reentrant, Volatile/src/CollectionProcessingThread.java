import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CollectionProcessingThread extends Thread {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 50;
    private Collection<Integer> collection;
    private int nRuns;
    private int propUpdate;
    static final Lock lockWrite;
    static final Lock lockRead;
    static ReentrantReadWriteLock rl= new ReentrantReadWriteLock();
    public static AtomicLong tries = new AtomicLong(0);
    static {
        lockRead = rl.readLock();
        lockWrite = rl.writeLock();
    }

    public CollectionProcessingThread(Collection<Integer> collection, int nRuns, int propUpdate) {
        this.collection = collection;
        this.nRuns = nRuns;
        this.propUpdate = propUpdate;
    }

    public void run() {
        for(int i = 0; i < nRuns; i++) {
            if(getRandomNumber(1, 100) < propUpdate) {
                update();
            } else {
                read();
            }
        }
    }

    private void read() {
        try {
            while(!lockRead.tryLock()) {
                tries.incrementAndGet();
            }
            collection.forEach(n -> getRandomNumber(0, n + 1));
        } finally {
            lockRead.unlock();
        }
    }

    private void update() {

        try {
            while(!lockWrite.tryLock()) {
                tries.incrementAndGet();
            }
            int number  = getRandomNumber(MIN_VALUE, MAX_VALUE);
            collection.remove(number);
            collection.add(number);
        } finally {
            lockWrite.unlock();
        }
    }

    private Integer getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
