import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Appl {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Andrey", 40),
                new Person("Vlad", 25),
                new Person("Masha",33));

        Optional<Person> res = findPersonByAge(persons, 25);
        Person who = res.orElseGet(() ->new Person("Noname", 99));
        res.ifPresent(System.out::println);
        System.out.println(who);

    }

    private static Optional<Person> findPersonByAge(List<Person> persons, int i) {
        Person person = null;
        for(Person p : persons){
            if(p.age == i) {
                person = p;
                break;
            }
        }
        return Optional.ofNullable(person);
    }
}
