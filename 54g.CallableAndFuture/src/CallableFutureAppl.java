import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureAppl {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < randomNumberTasks.length; i++) {
            Callable<Integer> callable = new CallableExample();

            randomNumberTasks[i] = new FutureTask<>(callable);

            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < randomNumberTasks.length; i++) {
            System.out.println(randomNumberTasks[i].get());
        }
    }
}
