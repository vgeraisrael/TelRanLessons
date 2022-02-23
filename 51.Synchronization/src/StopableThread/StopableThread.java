package StopableThread;

public class StopableThread extends Thread {
    private boolean isStopped = false;

    public StopableThread() {
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Run begin");

        while (!isStopped) {
            System.out.println("while");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 1_000_000_000; i++) {

            }
        }
        System.out.println("Run stooped");
    }

    public void changeRunning() {
        System.out.println("boolean is changed");
        isStopped = true;
    }
}
