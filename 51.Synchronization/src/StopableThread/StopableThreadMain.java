package StopableThread;

public class StopableThreadMain {

    public static void main(String[] args) throws InterruptedException {
        StopableThread st = new StopableThread();
        st.start();
        Thread.sleep(1000);
        st.changeRunning();
    }
}
