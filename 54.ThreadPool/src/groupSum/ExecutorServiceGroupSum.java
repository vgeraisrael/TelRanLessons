package groupSum;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceGroupSum extends GroupSum{
    int nThreads;

    public ExecutorServiceGroupSum(int[][] numbers) {
        super(numbers);
        Runtime runtime = Runtime.getRuntime();
        this.nThreads = runtime.availableProcessors();
    }

    public void setnThreads(int nThreads) {
        this.nThreads = nThreads;
    }

    @Override
    public long computeSum() {
        ExecutorService pool = Executors.newFixedThreadPool(nThreads);
        OneGroupSum[] groups = launchExecutor(pool);
        waitingThread(pool);
        return computeGroups(groups);
    }

    private long computeGroups(OneGroupSum[] groups) {
        return Arrays.stream(groups).mapToLong(g -> g.getSum()).sum();
    }

    private void waitingThread(ExecutorService pool) {
        pool.shutdown();
        try {
            pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private OneGroupSum[] launchExecutor(ExecutorService pool) {
        OneGroupSum[] gr = new OneGroupSum[numbers.length];
        for (int i = 0; i < gr.length; i++) {
            gr[i] = new OneGroupSum(numbers[i]);
            pool.execute(gr[i]);
        }
        return gr;
    }
}
