public class Appl {
    public static void main(String[] args) {
        MySingleton.INSTANCE.display();
        MySingleton.INSTANCE.display();

        MySingleton2 inst2 = MySingleton2.makeMySingletonInstance();
        inst2.display();
    }
}
