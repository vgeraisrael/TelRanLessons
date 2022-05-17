package StopableThread;

public class StopableThread extends Thread {
    private volatile boolean isStopped = false;

    public StopableThread() {
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Run begin");

        while (!isStopped ) {
            System.out.println("while");
            for(int i = 0; i < 1_000_000_000; i++) {

            }
        }
        System.out.println("Run stooped");
    }

    public synchronized void changeRunning() {
        System.out.println("boolean is changed");
        isStopped = true;
    }
}
