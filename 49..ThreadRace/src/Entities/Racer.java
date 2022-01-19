package Entities;

import Service.Game;

import java.util.concurrent.ThreadLocalRandom;

public class Racer implements Runnable{
    private int numberOfLaps;

    public Racer(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    @Override
    public void run() {
        for(int i = 1; i <= numberOfLaps; i++) {
            System.out.println(Thread.currentThread().getName() + " finished lap #" + i);
            try {
                Thread.currentThread().sleep(getPitStopTime());
                System.out.println(Thread.currentThread().getName() + " finished lap #" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Game.setWinner(Thread.currentThread().getName());
    }

    private int getPitStopTime() {
        return ThreadLocalRandom.current().nextInt(2, 5);
    }
}
