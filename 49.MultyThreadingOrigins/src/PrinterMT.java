public class PrinterMT extends Thread {
    char symbol;
    int nPrints;

    public PrinterMT(char symbol, int nPrints) {
        this.symbol = symbol;
        this.nPrints = nPrints;
    }

    @Override
    public void run() {
        for (int i = 0; i < nPrints; i++) {
            System.out.println(symbol);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
