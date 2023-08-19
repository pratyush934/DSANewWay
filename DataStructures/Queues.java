import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {

    static class staticArrayQueue {
        static int arr[];
        static int size;
        static int rear;

        staticArrayQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is FULL");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("EMpty Queeu");
                return Integer.BYTES;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return Integer.BYTES;
            }
            return arr[0];
        }

    }

    static class CircularArrayQueue {
        int arr[];
        int front;
        int rear;
        int size;

        CircularArrayQueue(int n) {
            arr = new int[n];
            size = n;
            front = rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.BYTES;
            }
            int var = arr[front];
            if (rear == front) {
                front = rear = -1;
            } else
                front = (front + 1) % size;

            return var;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return Integer.BYTES;
            }
            return arr[front];
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLL {
        public static Node head = null;
        public static Node tail = null;
        public static int size = 0;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.BYTES;
            }
            int var = head.data;
            if (head == tail) {
                head = tail = null;
            } else
                head = head.next;
            return var;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.BYTES;
            }
            return head.data;
        }
    }

    static class Queuewith2Stacks {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.BYTES;
            }
            return s1.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.BYTES;
            }
            return s1.peek();
        }
    }

    static class Stackwith2Queue {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }
            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }
            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void printNonReapeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.println(-1 + " ");
            } else {
                System.out.println(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void interLeave() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size(); // isko fix kar diya

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

    }

    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    static class StackwithDeque {
        Deque<Integer> d = new LinkedList<>();

        public boolean isEmpty() {
            return d.isEmpty();
        }

        public void push(int data) {
            d.addLast(data);
            ;
        }

        public int pop() {
            int var = d.removeLast();
            return var;
        }

        public int peek() {
            return d.getLast();
        }
    }

    static class QueuewithDeque {
        Deque<Integer> d = new LinkedList<>();
        public boolean isEmpty() {
            return d.isEmpty();
        }
        public void add(int data) {
            d.addLast(data);
        }
        public int remove() {
            return d.removeFirst();
        }
        public int peek() {
            return d.getFirst();
        }
    }
    public static void main(String[] args) {

        
    }
}
