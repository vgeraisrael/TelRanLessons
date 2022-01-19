package application;

import dto.Example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {

        Class clazz = Example.class;

//        Constructor[] constr = clazz.getDeclaredConstructors();
        Constructor<Example> cnstr = clazz.getDeclaredConstructor(int.class);
        cnstr.setAccessible(true);
//        System.out.println(Arrays.toString(constr));

        Example ex = cnstr.newInstance(3);
        System.out.println(ex);

        System.out.println((int)Integer.class.getDeclaredMethod("parseInt", String.class)
                .invoke(null, "12")/ex.getA());

        System.out.println(Example.class.getDeclaredField("PI").getDouble(null));
    }
}
