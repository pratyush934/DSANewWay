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
            while (arr.get(x) < arr.get(par)) { // O(log(n)) //>
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

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) { // >
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) { // <
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

    public static void heapSort(int arr[]) {
        // step1 -> build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // step2 -> push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    private static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }

    }

    static class Point implements Comparable<Point> {

        int x, y, distSq, idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            return this.distSq - o.distSq;
        }

    }

    public static void nearestCars() {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }

    public static void connectNropes() {
        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);

        }

        int cost = 0;
        while(pq.size() == 1) {
            int min = pq.remove();
            int secondMin = pq.remove();
            cost += min + secondMin;
            pq.add(min + secondMin);

        }

        System.out.println(cost);
    }

     

    public static void main(String[] args) {
        implementingHeaps();
    }
}
