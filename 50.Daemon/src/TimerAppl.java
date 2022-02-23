public class TimerAppl {
    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        timer.setTimeFormat("HH:mm:ss");
//        timer.setDaemon(true);
        timer.start();
        Thread.sleep(4000);
        timer.interrupt();
        timer = new Timer();
        timer.setTimeFormat("hh:mm:ss a");
        timer.start();
        Thread.sleep(5000);
        System.out.println("After");
    }
}
