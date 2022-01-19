import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeIntroAppl {
    public static void main(String[] args) {

        //? https://docs.oracle.com/javase/tutorial/datetime/iso/index.html

        LocalDate now = LocalDate.now();
        System.out.println(now);

        //* construct with LocalDate.of
        LocalDate birthday = LocalDate.of(2022, 2, 17);
        LocalDate date = LocalDate.of(2021, Month.JANUARY, 1);

        //* construct using parsing char sequence
        //? https://www.baeldung.com/java-string-to-date
        LocalDate date2 = LocalDate.parse("2021-02-28");
        System.out.println(date2);

        //* construct with ofYearDay
        LocalDate date3 = LocalDate.ofYearDay(2021, 30);
        System.out.println(date3);

        //* Which day of week is the given date
        System.out.println(LocalDate.of(1981, 02, 17).getDayOfWeek());

        //* Date shifting
        System.out.println(now.plusDays(7));
        System.out.println(now.plusDays(2).plusMonths(4));
        System.out.println(now.minusWeeks(2));

        //*Chronounits
        System.out.println(now.plus(2, ChronoUnit.DECADES));

        //*Period between two dates in chosen chronounit
        System.out.println(ChronoUnit.DAYS.between(now, birthday));

        //!Date formatter shortcodes
        /*
y – Year (1996; 96)
M – Month in year (July; Jul; 07)
d – Day in month (1-31)
E – Day name in week (Friday, Sunday)
a – AM/PM marker (AM, PM)
H – Hour in day (0-23)
h – Hour in AM/PM (1-12)
m – Minute in hour (0-60)
s – Second in minute (0-60)
         */

        //*DateTime formating and parsing
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eee, dd-MM-yyy, HH:mm:ss", Locale.ENGLISH);
        System.out.println(LocalDateTime.now().format(dtf));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("eeee, dd-MM-yyy, HH:mm:ss", Locale.forLanguageTag("HE"));
        System.out.println(LocalDateTime.now().format(dtf2));

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern( "dd-MM-yyy HH:mm:ss");
        LocalDateTime fromParsing = LocalDateTime.parse("12-12-1989 12:20:10", dtf3);
        System.out.println(fromParsing.format(dtf));
    }
}
