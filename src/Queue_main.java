import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue_main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(9);
        pq.add(11);
        System.out.println(pq);

//        Comparator<Integer> compRev = (Comparator<Integer>) pq.comparator().reversed();
//        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(compRev);
//        System.out.println(pq);

        System.out.println(pq.comparator());
        System.out.println(pq.poll());
        System.out.println(pq.remove());
        System.out.println(pq);

        pq.clear();
        System.out.println(pq.poll());
        try {
            System.out.println(pq.remove());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
