package telran.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Receiver extends Thread {
    MessageBox box;
    static AtomicInteger counter = new AtomicInteger();
    public volatile boolean running = true;

    public Receiver(MessageBox box) {
        this.box = box;
    }

    public void run() {
            while (running) {
                String message = box.takeMessage();
                System.out.println(message + " " + this.getName());
                System.out.println(counter.incrementAndGet());
            }
    }
}
