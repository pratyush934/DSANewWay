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

                // update
                x = par;
                par = (x - 1) / 2;
            }
            /* if a tree has n nodes then log(n) level is possible */
        }

        public int peek() {
            // ArrayList ke 0th index me jo store hai wo subse min hoga
            return arr.get(0);
        }

        public int remove() {
            int data = arr.get(0);

            // step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set((arr.size() - 1), temp);

            // step2 --> delete last
            arr.remove(arr.size() - 1);

            // step3 --> heapify
            heapify(0);
            return data;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void implementingHeaps() {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek() + "-->");
            h.remove();
        }
    }

    public static void main(String[] args) {
        implementingHeaps();
    }
}
