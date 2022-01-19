public class Cat implements Runnable{

    String name;
    char gender;
    int myau;

    public Cat(String name, char gender, int myau) {
        this.name = name;
        this.gender = gender;
        this.myau = myau;
    }

    @Override
    public void run() {
        System.out.println(name + " says");
        for (int i = 0; i<myau; i++){
            System.out.println("iiiiay");
        }
    }
}
