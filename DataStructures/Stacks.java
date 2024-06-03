import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class Stacks {

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
                System.out.println("Sorry But Stack is Empty");
                return Integer.BYTES;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Sorry But Stack is Empty");
                return Integer.BYTES;
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
                System.out.println("LL is Empty");
                return Integer.BYTES;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (head == null) {
                System.out.println("LL is Empty");
                return Integer.BYTES;
            }
            return head.data;
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) { /* O(n) */
        if (s.empty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void mainQ1() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);

        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static String reveString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {

        if (s.empty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void mainQ2() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverseStack(s);

        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currHigh = stocks[i];
            while (!s.empty() && currHigh > stocks[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void mainQ3() {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        for (int i : span) {
            System.out.print(i + " ");
        }
    }

    public static void nextGreater(int arr[], int ans[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!s.empty() && curr >= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void mainQ4() {
        int arr[] = { 1, 2, 3, 4, 3 };
        int ans[] = new int[arr.length];
        nextGreater(arr, ans);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (!s.empty() && s.peek() == '(') {
                    s.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == '}') {
                if (!s.empty() && s.peek() == '{') {
                    s.pop();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == ']') {
                if (!s.empty() && s.peek() == '[') {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                s.push(str.charAt(i));
            }
        }
        if (s.empty()) {
            return true;
        } else
            return false;

    }

    public static boolean validParenthesis2(String str) {
        Stack<Character> s = new Stack<>();
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '[' || ch == ')') {
                s.push(ch);
            } else {
                if (s.empty()) {
                    return true;
                } else {
                    if ((s.peek() == '(' && ch == ')') ||
                            (s.peek() == '[' && ch == ']') ||
                            s.peek() == '{' && ch == '}') {
                        s.pop();
                    } else {
                        return false;
                    }
                }
            }

        }
        if (s.empty()) {
            return true;
        } else
            return false;

    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop(); // opening pair
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next Smaller Right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int currLow = arr[i];
            while (!s.empty() && currLow <= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // next Smaller Left
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int currLow = arr[i];
            while (!s.empty() && currLow <= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // calculating area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);

        }
        System.out.println(maxArea);

    }

    public static void mainQ5() {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }

    public static void main(String[] args) {
        mainQ4();

    }
}
