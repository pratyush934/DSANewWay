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
                System.out.println("Empty Stacks");
                return Integer.MAX_VALUE;
            }
            int value = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Stacks");
                return Integer.MAX_VALUE;
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
        public static int size = 0;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Empty Stacks");
                return Integer.MAX_VALUE;
            }
            if (size == 1) {
                int value = head.data;
                head = tail = null;
                return value;
            }
            int value = head.data;
            head = head.next;
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Stacks");
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

    public static String revString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
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
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!s.isEmpty() && curr > arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static boolean validParenthesis(String str) {
        if (str.length() == 0 || str == null) {
            return true;
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ']') {
                if (!s.isEmpty() && s.peek() == '[') {
                    s.pop();
                } else {
                    return false;
                }
            } else if (ch == ')') {
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop();
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (!s.isEmpty() && s.peek() == '{') {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                s.push(ch);
            }
        }
        if (s.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean validParenthesis2(String str) {
        if (str.length() == 0 || str == null) {
            return true;
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return true;
                } else {
                    if ((s.peek() == '[' && ch == ']') || (s.peek() == '{' && ch == '}')
                            || (s.peek() == '(' && ch == ')')) {
                        s.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (s.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ')') {
                int count = 0;
                while(str.charAt(i) != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(str.charAt(i));
            }
        }
        return false;
    }

    public static void maxArea(int height[]) {
        Stack<Integer> s = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        /* nsl */
        int nsl[] = new int[height.length];
        for(int i=0; i<height.length; i++) {
            int curr = height[i];
            while(!s.isEmpty() && curr < height[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = height[s.peek()];
            }
            s.push(i);
        }
        s = new Stack<>();
        /* nsr */
        int nsr[] = new int[height.length];
        for(int i=0; i<height.length; i++) {
            int curr = height[i];
            while(!s.isEmpty() && curr < height[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = height.length;
            } else {
                nsr[i] = height[s.peek()];
            }
            s.push(i);
        }
        /* calculation */
        for(int i=0; i<height.length; i++) {
            int ht = height[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = ht * width;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis2(""));
    }
}