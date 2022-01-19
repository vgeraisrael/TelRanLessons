public class Main {
    public static void main(String[] args) {
        int a = sumOfArithmeticProgression(5);
        System.out.println(a);

        int b = factorialRec(5);
        System.out.println(b);

    }

    public static int sumOfArithmeticProgression(int number) {
        if (number <= 0) {
            return 0;
        } else {
            return number + sumOfArithmeticProgression(number - 1);
        }
    }

    public static int factorialRec(int number){
        return number == 0 ? 1 : number * factorialRec(number - 1);
    }
}
