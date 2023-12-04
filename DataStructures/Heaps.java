//For terminal Ctrl + `
//Remeber it

import java.util.ArrayList;
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
            return this.rank - o.rank; // o.rank - this.rank for descending
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

    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // adding in the last index
            arr.add(data);

            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // par index

            // will swap until child is less than parent
            while (arr.get(x) < arr.get(par)) { // O(log(n))
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
            /* if a tree has n nodes then log(n) level is possible */
        }
    }

    public static void main(String[] args) {
        introductionTOComparable();
    }
}
