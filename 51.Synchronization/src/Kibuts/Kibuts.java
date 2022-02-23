package Kibuts;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Kibuts {

    public static final int N_TRUCKS = 3;
    public static final int LOAD = 1000;
    public static final int N_LAPS = 1000;

    public static void main(String[] args) throws InterruptedException {
        Truck[] trucks = new Truck[N_TRUCKS];

        for(int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(LOAD, N_LAPS);
            trucks[i].start();
        }

        for(int i = 0; i < trucks.length; i++) {
            trucks[i].join();
        }

        Instant start = Instant.now();
        seasonReport(start);

    }

    private static void seasonReport(Instant start) {
        System.out.printf("Running time is %d\nElevator 1 contains %d\nElevator 2 contains %d\n",
                ChronoUnit.NANOS.between(start, Instant.now()), Truck.getElevator1(), Truck.getElevator2());

    }
}
