import reflection.Cat;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CatAppl {
    public static void main(String[] args) {

        Cat cat1 = new Cat();

        try {
            Class catClass = Class.forName("reflection.Cat");
            Field[]fields = catClass.getFields();
            for(Field f : fields) {
                System.out.println(f.toString());
            }

            System.out.println();
            System.out.println("Contract fields");
            Field[] declaredFields = catClass.getDeclaredFields();
            for(Field f : declaredFields) {
                System.out.println(f.toString());
            }

            Field catField = catClass.getDeclaredField("age");
            catField.setAccessible(true);
            System.out.println(catField.get(cat1));

            catField.set(cat1, 12);
            System.out.println(catField.get(cat1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
