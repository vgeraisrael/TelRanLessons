public class MySingleton {
    public static final MySingleton INSTANCE = new MySingleton();

    private MySingleton() {
        System.out.println("Singleton created");
    }

    public void display(){
        System.out.println("I`m a singleton");
    }
}
