import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.*;

public class DateTimeII {
    public static void main(String[] args) {
        Instant i = Instant.now();
        System.out.println(i.toEpochMilli());
        for(int in1 = 0; in1 < 1_000_000; in1++){
            int b = 1+1+1;
        }
        System.out.println(ChronoUnit.MILLIS.between(i, Instant.now()));
        System.out.println(ChronoUnit.MICROS.between(i, Instant.now()));

        LocalDate ld = LocalDate.now();
        System.out.println(ld.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().with(TemporalAdjusters.lastDayOfYear())));

        TemporalQuery <TemporalUnit> query = TemporalQueries.precision();
        System.out.println(LocalDate.now().query(query));
    }
}
