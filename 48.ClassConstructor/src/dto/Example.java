package dto;

public class Example {
    private int a;
    public static double PI = 3.14;

    private Example(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Example{" +
                "a=" + a +
                '}';
    }

    public int getA() {
        return a;
    }
}
