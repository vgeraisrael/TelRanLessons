package Service;

import Entities.Racer;

import java.sql.SQLOutput;

public class Game {
    private static String winnerName = null;
    private int lapNumbers;

    public Game(int lapNumbers) {
        this.lapNumbers = lapNumbers;
    }

    public static void setWinner(String name) {
        if(winnerName == null) {
            winnerName = name;
        }
    }

    public void startGame() throws InterruptedException {

        winnerName = null;

        Thread thread1 = new Thread(new Racer(lapNumbers));
        Thread thread2 = new Thread(new Racer(lapNumbers));
        Thread thread3 = new Thread(new Racer(lapNumbers));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("The winner is : " + winnerName);
    }
}
