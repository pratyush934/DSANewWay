import java.util.ArrayList;
import java.util.Stack;

public class StackRevision {

    static class StacksArrayList {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean empty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (empty()) {
                System.out.println("Stacks is Empty");
                return Integer.MIN_VALUE;
            }
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (empty()) {
                System.out.println("Stack is Empty");
                return Integer.MIN_VALUE;
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

        public boolean empty() {
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
            if (empty()) {
                System.out.println("LL is Empty");
                return Integer.MIN_VALUE;
            }
            if (head == tail) {
                int val = head.data;
                head = tail = null;
                size--;
                return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        public int peek() {
            if (empty()) {
                System.out.println("LL is Empty");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.empty()) {
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

    public static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;

        for (int i = 0; i < stock.length; i++) {
            int curr = stock[i];

            while (!s.empty() && curr > stock[s.peek()]) {
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

    public static void nextGreater(int arr[], int ans[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];

            while (!s.empty() && curr > arr[s.peek()]) {
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

    public static boolean isValidParenthesis(String str) {
        if (str == null || str.length() == 0)
            return true;

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ']') {
                if (!s.empty() && s.peek() == '[') {
                    s.pop();
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (!s.empty() && s.peek() == '{') {
                    s.pop();
                } else {
                    return false;
                }
            } else if (ch == ')') {
                if (!s.empty() && s.peek() == '(') {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                s.push(ch);
            }
        }
        if (s.empty())
            return true;
        else
            return false;
    }

    public static boolean isValidParenthesis1(String str) {
        if(str == null || str.length() == 0) 
        return true;

        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '[' || ch == '{' || ch == '(') {
                s.push(ch);
            } else {
                if(s.empty()) {
                    return false;
                } else {
                    if((ch == ']' && s.peek() == '[') || (ch == ')' && s.peek() == '(') || (ch == '}' && s.peek() == '{')) {
                        s.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return s.empty();
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return s.empty();
    }

    public static void maxAreaHistogram(int arr[]) {
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];
            while(!s.empty() && curr <= arr[i]) {
                s.pop();
            }
            if(s.empty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = arr[s.peek()];
            }
            s.push(i);
        }

        s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            int curr = arr[i];
            while(!s.empty() && curr <= arr[i]) {
                s.pop();
            }
            if(s.empty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max area is : "+ maxArea);
    }
    public static void main(String[] args) {
        System.out.println(isValidParenthesis1("[[[[{}]]]]"));
    }
}