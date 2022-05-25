package telran;

import telran.concurrent.MessageBox;
import telran.concurrent.Receiver;
import telran.concurrent.Sender;

public class MBAppl {
    private static final int N_RECEIVERS = 10;

    public static void main(String[] args) throws InterruptedException {
        MessageBox box = new MessageBox();
        Sender sender = new Sender(box);
        Receiver[] receivers = new Receiver[N_RECEIVERS];

        sender.start();

        for (int i = 0; i < N_RECEIVERS ; i++) {
            receivers[i] = new Receiver(box);
            receivers[i].setDaemon(true);
            receivers[i].start();
        }

        sender.join();

        stopReceivers(receivers);

        Thread.sleep(2000);

    }

    private static void stopReceivers(Receiver[] receivers) {
        for (int i = 0; i < receivers.length; i++) {
            receivers[i].running = false;
        }
    }
    }
