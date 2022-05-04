package telran.concurrent;

public class Receiver extends Thread {
    MessageBox box;
    public volatile boolean running = true;

    public Receiver(MessageBox box) {
        this.box = box;
    }

    public void run() {
            while (running) {
                String message = box.takeMessage();
                System.out.println(message + " " + this.getName());
            }
    }
}
