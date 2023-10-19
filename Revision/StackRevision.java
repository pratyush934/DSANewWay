import java.util.ArrayList;

public class StackRevision {

    static class StacksArrayList {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if(isEmpty()) {
                System.out.println("Stack Is Empty");
                return Integer.MAX_VALUE;
            }
            return list.remove(list.size()-1);
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return list.get(list.size()-1);
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

    static class StacksLL {
        public static Node head = null;
        public static Node tail = null;

        public boolean isEmpty() {
            return head == null;
        }
        
        public void push(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if(head == null) {
                System.out.println("Stack is Empty");
                return Integer.MAX_VALUE;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek() {
            if(head == null) {
                System.out.println("Stack is Empty");
                return Integer.MAX_VALUE;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        StacksLL s = new StacksLL();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}