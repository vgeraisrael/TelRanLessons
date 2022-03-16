package GroupSumTest;

import groupSum.ExecutorServiceGroupSum;

import java.util.Random;

public class PerformanceTestAppl {

    public static final int N_GROUPS = 1000;
    public static final int N_NUMBERS = 100_000;

    public static void main(String[] args) {

        int[][] numbers = createMultydimentionalArray();
        ExecutorServiceGroupSum groupSum = new ExecutorServiceGroupSum(numbers);
        GroupSumPerformance test = new GroupSumPerformance(groupSum);
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.availableProcessors());
        System.out.println("Optimal N_Thread");
        test.runTest();
        System.out.println();

        for(int nThread = 200; nThread <=2000; nThread += 200){
            System.out.println("NThreads = " + nThread);
            groupSum.setnThreads(nThread);
            test.runTest();
            System.out.println();
        }
    }

    private static int[][] createMultydimentionalArray() {
        Random rand = new Random();
        int[][] res = new int[N_GROUPS][N_NUMBERS];
        for(int i = 0; i < N_GROUPS; i++){
            res[i] = rand.ints(N_NUMBERS, 1, Integer.MAX_VALUE).toArray();
        }
        return res;
    }

}
