public class Appl {
    public static void main(String[] args) {
        Weekdays first = Weekdays.SUN;
        Weekdays last = Weekdays.SUN;
        if(last == first)
            System.out.println("Same object " + last);

        displayComments(Weekdays.FRI);

    }

    public static void displayComments(Weekdays day)
    {
        switch (day){
            case SUN:
                System.out.println("First working day in Israel");
                break;
            case SAT:
                System.out.println("Weekend");
                break;
            case FRI:
                System.out.println("Time to drink");
                break;
            default:
                System.out.println("Ordinary day");
        }
    }
}
