//For terminal Ctrl + `
//Remeber it

import java.util.Comparator;
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

    public static void reversingPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(1);
        pq.add(-1);
        pq.add(3);
        pq.add(2);

        System.out.println(pq);
    }

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;

        }

        @Override
        public int compareTo(Heaps.Student o) {
            return this.rank - o.rank; //o.rank - this.rank for descending 
        }
    }

    public static void introductionTOComparable() {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Chunnu", 1300));
        pq.add(new Student("Munnu", 1121));
        pq.add(new Student("Kunnu", 1562));
        pq.add(new Student("Gunnu", 4576));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "--->" + pq.peek().rank);
            pq.remove();
        }
    }

    

    public static void main(String[] args) {
        introductionTOComparable();
    }
}
