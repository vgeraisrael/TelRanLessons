public class TimerAppl {
    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        timer.setTimeFormat("HH:mm:ss");
        timer.start();
        Thread.sleep(40000);
    }
}
