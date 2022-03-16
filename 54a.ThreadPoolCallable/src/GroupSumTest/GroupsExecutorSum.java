package GroupSumTest;

import groupSum.OneGroupSum;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GroupsExecutorSum {
    public static final int N_GROUPS = 1000;
    public static final int N_NUMBERS = 10_000;

    public static void main(String[] args) {
        int[][] groups = getRandomGroups();
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Long>[] groupTask = new Future[N_GROUPS];

        for(int i = 0; i < N_GROUPS; i++){
            groupTask[i] = es.submit(new OneGroupSum(groups[i]));
        }
        es.shutdown();
        long sum = Arrays.stream(groupTask).mapToLong(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                return 0;
            } catch (ExecutionException e) {
                return 0;
            }
        }).sum();
        System.out.println(sum);
    }

    private static int[][] getRandomGroups() {
        Random rand = new Random();
        int[][] res = new int[N_GROUPS][N_NUMBERS];
        for(int i = 0; i < N_GROUPS; i++){
            res[i] = rand.ints(N_NUMBERS, 1, Integer.MAX_VALUE).toArray();
        }
        return res;
    }
}
