import java.util.ArrayList;
import java.util.Stack;

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
            if (isEmpty()) {
                System.out.println("Stack Is Empty");
                return Integer.MAX_VALUE;
            }
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return list.get(list.size() - 1);
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
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return Integer.MAX_VALUE;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return Integer.MAX_VALUE;
            }
            return head.data;
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!s.isEmpty()) {
            sb.append(s.peek());
            s.pop();
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty())
            return;

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;

        for (int i = 1; i < stocks.length; i++) {
            int curr = stocks[i];
            while (!s.isEmpty() && curr > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }

            s.push(i);
        }

    }

    public static void nextGreater(int arr[], int ans[]) {
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            int curr = arr[i];
            while(!s.isEmpty() && curr >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static boolean isValidParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        if(str.length() == 0 || str == null) {
            return true;
        }

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
        }
    }
    public static void main(String[] args) {

    }
}