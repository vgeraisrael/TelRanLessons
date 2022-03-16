package Deadlock;

public class Feeder extends Thread{

    Dog dog1;
    Dog dog2;

    public Feeder(Dog dog1, Dog dog2) {
        this.dog1 = dog1;
        this.dog2 = dog2;
    }

public void run(){
    for (int i = 0; i <=10_000; i++) {
        synchronized (dog2) {
            dog2.eat();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (dog1) {
                dog1.eat();
            }
        }
    }
}


}
