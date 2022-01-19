public class MySingleton2 {
    private static MySingleton2 instance;

    public MySingleton2() {
        System.out.println("Singleton2 created");
    }

    public static MySingleton2 makeMySingletonInstance(){
        if(instance == null)
            instance = new MySingleton2();
        return instance;
    }

    public void display(){
        System.out.println("I`m a singleton2");
    }
}
