import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueRevision {
    static class StaticArrayQueue {
        static int arr[];
        static int size;
        static int rear;

        public StaticArrayQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public boolean isEmpty() {
            return rear == -1;
        }
        public boolean isFull() {
            return rear == size - 1;
        }
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = data;
        }
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MAX_VALUE;
            }
            int value = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return value;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MAX_VALUE;
            }
            return arr[0];
        }
    }

    static class CircularArrayQueue {
        static int arr[];
        static int size;
        static int rear , front;

        public CircularArrayQueue(int n) {
            arr = new int[n];
            size = n;
            rear = front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        public boolean isFull() {
            return (rear+1) % size == front;
        }
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is Full");
                return ;
            }
            if(front == -1) {
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MAX_VALUE;
            }
            int value = arr[front];
            if(rear == front) {
                rear = front = -1;
            } else
            front = (front + 1) % size;

            return value;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MAX_VALUE;
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
            return head == null;
        }
        public void add(int data) {
            Node newNode = new Node(data);
            size++;
            if(head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MAX_VALUE;
            }
            if(size == 1) {
                int value = head.data;
                head = tail = null;
                size--;
                return value;
            }
            int value = head.data;
            head = head.next;
            size--;
            return value;
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MAX_VALUE;
            }
            return head.data;
        }
    }

    static class Queuewith2Stacks {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
        public void add(int data) {

            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public int remove() {
            if(isEmpty()) {
                System.out.println("Sorry");
                return Integer.MAX_VALUE;
            }
            return s1.pop();
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Sorry");
                return Integer.MAX_VALUE;
            }
            return s1.peek();
        }
    }

    public static void printNonReapeating(String str) {
        /* JAB BHI KAHI STREAM OF CHARACTERS DIKHE WAHA QUEUE KA CONCEPT LAGAO */
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for(int i=0; i<str.length(); i++) {
            q.add(str.charAt(i));
            freq[str.charAt(i)-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(q.peek());
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int n = q.size();
        for(int i=0; i<n/2; i++) {
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }

    static class StackwithDeque {
        static Deque<Integer> d = new LinkedList<>();
        public boolean isEmpty() {
            return d.isEmpty();
        }
        public void push(int data) {
            d.addFirst(data);
        }
        public int pop() {
            if(isEmpty()) {
                System.out.println("Sorry");
                return Integer.MAX_VALUE;
            }
            return d.removeFirst();
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Sorry");
                return Integer.MAX_VALUE;
            }
            return d.getFirst();
        }
    }

    static class QueuewithDeque {
        static Deque<Integer> d = new LinkedList<>();

        public boolean isEmpty() {
            return d.isEmpty();
        }
        public void push(int data) {
            d.addLast(data);
        }
        public int pop() {
            if(isEmpty()) {
                System.out.println("Sorry");
                return Integer.MAX_VALUE;
            }
            return d.removeFirst();
        }
        public int peek() {
            if(isEmpty()) {
                System.out.println("Sorry");
                return Integer.MAX_VALUE;
            }
            return d.getFirst();
        }
    }
    public static void main(String[] args) {
        QueuewithDeque q = new QueuewithDeque();
        q.push(1);
        q.push(2);
        q.push(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.pop();
        }
    }
}