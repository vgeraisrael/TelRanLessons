package telran.concurrent;

public class MessageBox {
    private String message;

    synchronized public void putMessage(String message) {
        while (this.message != null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        this.notify();
    }

    synchronized public String takeMessage() {
        while(message == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String res = message;
        message = null;
        this.notifyAll();
        return res;
    }
}
