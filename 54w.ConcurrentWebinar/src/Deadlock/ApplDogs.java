package Deadlock;

public class ApplDogs {
    public static void main(String[] args) {
        Dog gera = new Dog("Gera", 3);
        Dog boss = new Dog("Boss", 5);
        Walker Jim = new Walker(gera, boss);
        Feeder Karl = new Feeder(gera, boss);

        Jim.start();
        Karl.start();
    }
}
