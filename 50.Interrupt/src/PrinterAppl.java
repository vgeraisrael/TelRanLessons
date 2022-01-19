import java.util.Scanner;

public class PrinterAppl {

    public static void main(String[] args) throws InterruptedException {
        PrinterInter pi = new PrinterInter("qwerty");
        pi.start();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if(line.equals("1"))
                break;
            pi.interrupt();
        }
        sc.close();
    }
}
