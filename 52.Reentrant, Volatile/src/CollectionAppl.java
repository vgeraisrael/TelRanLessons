import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class CollectionAppl {

    public static final int N_THREADS = 10;
    public static final long N_NUMS = 100;
    public static final int N_RUNS = 1000;
    public static final int PROP_UPDATE = 50;

    public static void main(String[] args) {
        CollectionProcessingThread[] threads = new CollectionProcessingThread[N_THREADS];
        startThreads(threads);
        waitThreads(threads);

        System.out.println(CollectionProcessingThread.tries);

    }

    private static void waitThreads(CollectionProcessingThread[] threads) {
        for (CollectionProcessingThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startThreads(CollectionProcessingThread[] threads) {
        Collection<Integer> collection = getRandomCollection();
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new CollectionProcessingThread(collection, N_RUNS, PROP_UPDATE);
            threads[i].start();
        }
    }

    private static Collection<Integer> getRandomCollection() {
        return new Random()
                .ints(N_NUMS, CollectionProcessingThread.MIN_VALUE, CollectionProcessingThread.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());
    }
}
