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



    public static void main(String[] args) {
        System.out.println(isValid("(A+B)+(C-D)"));
    }
}
