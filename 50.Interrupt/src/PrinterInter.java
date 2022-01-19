public class PrinterInter extends Thread {

    private String str;
    private int length;

    public PrinterInter(String str) {
        setDaemon(true);
        this.str = str;
        length = str.length();
    }

    public void run() {
        int index = 0;
        while(true){
            System.out.println(str.charAt(index));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                index++;
                if(index == length) index = 0;
            }
        }
    }
}
