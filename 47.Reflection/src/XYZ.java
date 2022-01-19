import reflection.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;

public class XYZ {
    public static void main(String[] args) throws ClassNotFoundException {
//        IX x1 = new Y();
//        IX x2 = new Y();
//        IX x3 = new Z();
        IX x4 = new Y();
//        String s = "11";

        Class clazz = x4.getClass();
        System.out.println(clazz);

        Class clazz2 = Class.forName("reflection.Z");
        System.out.println(clazz2);

        Class wrap = Integer.TYPE; //!only for wrapper classes
        System.out.println(wrap);

        for (int i = 0; i<args.length; i+=2)  {
            try {
                Class<IX> clazzN = (Class<IX>)Class.forName("reflection." +  args[i]);
                int params = clazz.getConstructor().getParameterCount();
                Class[] paramsT = clazz.getConstructor().getParameterTypes();
                IX x;
                if(args[i].contains("Z")) {
                    x = clazzN.getConstructor(String.class).newInstance(args[i+1]);
                } else {
                    x = clazzN.getConstructor().newInstance();
                }
                x.action();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
