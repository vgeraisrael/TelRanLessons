package Deadlock;

public class Walker extends Thread{
    Dog dog1;
    Dog dog2;

    public Walker(Dog dog1, Dog dog2) {
        this.dog1 = dog1;
        this.dog2 = dog2;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <= 10_000; i++) {
            synchronized (dog1) {
                dog1.walk();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (dog2) {
                    dog2.walk();
                }
            }
        }
    }
}
