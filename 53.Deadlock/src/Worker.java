public class Worker extends Thread {
    private static final Object mutex1 = new Object();
    private static final Object mutex2 = new Object();
    private int nRuns;

    public Worker(int nRuns) {
        this.nRuns = nRuns;
    }

    void f1() {
        synchronized (mutex1) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (mutex2) {
                System.out.println("1");
            }
        }
    }

    void f2() {
        synchronized (mutex1) {
            synchronized (mutex2) {
                System.out.println("2");
            }
        }
    }

    public void run(){
        for(int i = 0; i < nRuns; i++){
            f1();
            f2();
        }
    }
}
