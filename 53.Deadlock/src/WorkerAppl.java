public class WorkerAppl {
    private static final int N_RUNS = 100;

    public static void main(String[] args) {
        Worker worker1 = new Worker(N_RUNS);
        Worker worker2 = new Worker(N_RUNS);

        worker1.start();
        worker2.start();

//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
