import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrinterAppl {
    public static void main(String[] args) throws InterruptedException {

        PrinterMT p1 = new PrinterMT('#', 10);
        PrinterMT p2 = new PrinterMT('*', 10);

        Instant instant = Instant.now();


        p2.start();
        p1.start();
        p2.join(1);
        p1.join(1);

        System.out.println(ChronoUnit.MILLIS.between(instant, Instant.now()));

//        Cat cat = new Cat("a", 'm', 3);
//        Cat cat2 = new Cat("b", 'm', 4);
//        Cat cat3 = new Cat("c", 'f', 6);
//        Cat cat4 = new Cat("d", 'm', 8);
//
//        Thread th1 = new Thread(cat);
//        Thread th2 = new Thread(cat2);
//        Thread th3 = new Thread(cat3);
//        Thread th4 = new Thread(cat4);
//
//        th1.start();
//        th2.start();
//        th3.start();
//        th4.start();
    }
}
