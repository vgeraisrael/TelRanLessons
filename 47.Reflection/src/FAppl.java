import reflection.F;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FAppl {
    public static void main(String[] args) {

        F f = new F();

        System.out.println("Protocol methods");
        for(Method m : F.class.getMethods()) { //!Protocol methods
            System.out.println(m.getName());
        }

        System.out.println();
        System.out.println("Contract methods");
        for(Method m : F.class.getDeclaredMethods()) { //!Contract methods
            System.out.println(m.getName());
        }

        try {
            for(int i = 0; i< args.length; i+=2) {
                Method m = F.class.getDeclaredMethod(args[i], String.class);
                m.setAccessible(true);
                m.invoke(f, args[i+1]);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
