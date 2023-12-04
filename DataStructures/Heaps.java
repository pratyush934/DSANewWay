//For terminal Ctrl + `
//Remeber it

import java.util.PriorityQueue;

public class Heaps {

    public static void implementingPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(-1);
        pq.add(3);
        pq.add(2);

        System.out.println(pq);
    }

    

    public static void main(String[] args) {
        implementingPQ();
    }
}
