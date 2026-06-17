package CollectionFramework;
import java.util.Collections;
import java.util.PriorityQueue;

public class NewClass {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(33);
        pq.add(23);
        pq.add(56);
        pq.add(353);
        pq.add(88);

        System.out.println(pq);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
