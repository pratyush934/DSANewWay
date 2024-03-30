package DSA_BOOK.Stacks;

import java.util.Stack;

public class Questions {

    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
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
            } else if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                continue;
            }
        }

        return s.isEmpty();

    }

    /*
     * postfix ,
     * prefix,
     * infix
     * MUST TOPICS
     */

    public static int postfixEvaluation(String[] str) {
        /*
         * You know how to calculate the output of an expression using postfix
         * evaluation.
         */

        if (str == null || str.length == 0) {
            return 0;
        }

        Stack<Integer> s = new Stack<>();
        for (String string : str) {
            if (string.equals("+")) {
                int temp1 = s.pop();
                int temp2 = s.pop();
                s.push(temp1 + temp2);
            } else if (string.equals("*")) {
                int temp1 = s.pop();
                int temp2 = s.pop();
                s.push(temp1 * temp2);
            } else if (string.equals("-")) {
                int temp1 = s.pop();
                int temp2 = s.pop();
                s.push(temp2 - temp1);
            } else if (string.equals("/")) {
                int temp1 = s.pop();
                int temp2 = s.pop();
                s.push(temp2 / temp1);
            } else {
                s.push(Integer.parseInt(string));
            }
        }
        return s.pop();
    }


/*     public static String infixToPostFix(String str) {
        
        Stack<Character> s = new Stack<>();
        StringBuffer sb = new StringBuffer();

 
        for(int i =0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                s.push(ch);
            } else if(ch == '*' || ch == '+' || ch == '/' || ch == '-') {
                s.push(ch);
            } else if(ch == ')') {
                while(!(s.peek() == '(')) {
                    sb.append(s.pop());
                }
                s.pop();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    --> It is wrong and is quite tough question to consider
    */

    public static int evaluationofInfix(String str) {
        /* 
         * Algorithm
         * 1. 
         */
        return 0;
    }

    static class AdvanceStackToGetMinimum {
        public Stack<Integer> elementStack = new Stack<>();
        public Stack<Integer> minStack = new Stack<>();
        int data;
        public AdvanceStackToGetMinimum() {

        }
        public boolean isEmpty() {
            return elementStack.isEmpty();
        }

        public void push(int data) {
            elementStack.push(data);

            if(minStack.isEmpty() || minStack.peek() >= data) {
                minStack.push(data);
            } 
        }

        public int pop() {
            return elementStack.pop();
        }

        public int minPoP() {
            return minStack.pop();
        }

        public int peek() {
            return elementStack.peek();
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            while(!elementStack.isEmpty()) {
                sb.append(elementStack.pop()+" -- ");
            }

            return "[ " + sb.toString() + "]";
        }

    }

    public static boolean isPalindromeInArray(int arr[]) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i <= j) {
            if(arr[i++] != arr[j--]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeInNotReverse(String str) {
        /* 
         * there is a character X in middle
         */
        char arr[] = str.toCharArray();
        Stack<Character> s = new Stack<>();
        int i = 0;
        for(i = 0; i<arr.length; i++) {
            char ch = arr[i];
            if(ch != 'X') {
                s.push(ch);
            } else if(ch == 'X') {
                break;
            }
        }

        for(int j=i+1; j<arr.length; j++) {
            char ch = arr[j];
            char sch = s.pop();
            if(ch != sch) {
                return false;
            }
        }

        return true;
    }

    public static void pushAtBottom(Stack<Integer> s ,int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    } 
    
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }


    public static void main(String[] args) {
       
    }

}
