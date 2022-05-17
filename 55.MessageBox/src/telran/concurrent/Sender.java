package telran.concurrent;

public class Sender extends Thread{
    MessageBox box;

    public Sender(MessageBox box) {
        this.box = box;
    }

    public void run() {
        for(int i = 1; i <= 20; i++) {
            box.putMessage("message-" + i);
        }
    }
}
