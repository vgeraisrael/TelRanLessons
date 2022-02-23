package Kibuts;

import java.util.concurrent.atomic.AtomicLong;

public class Truck extends Thread {
    int load;
    int nLaps;

    private static AtomicLong elevator1 = new AtomicLong();
    private static long elevator2 = 0;

    public Truck(int load, int nLaps) {
        this.load = load;
        this.nLaps = nLaps;
    }

    public static long getElevator1() {
        return elevator1.get();
    }

    public static long getElevator2() {
        return elevator2;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < nLaps; i++) {
            loadElevator1();
            loadElevator2();
        }
    }

    private void loadElevator2() {
        synchronized (Truck.class) {
            elevator2 += load;
        }
    }
    private void loadElevator1() {
            elevator1.addAndGet(load);

    }
}
