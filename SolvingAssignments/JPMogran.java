package SolvingAssignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DSA_BOOK.LinkedList.ListNode;

public class JPMogran {

    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int question1(String[] arr, String target, int startingIndex) {

        int i = startingIndex;
        int count = 0;
        while (true) {
            if (arr[i].equals(target)) {
                return (arr.length + i) % startingIndex;
            }
            i++;
            i = i % arr.length;
            count++;
            if (count == arr.length - 1) {
                break;
            }
        }
        return -1;

    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static long question2(ListNode head) {
        /*
         * Given a Linked List having either 0 or 1 as its elements, find the decimal
         * representation of the binary number formed by the nodes of the list.
         * 
         * Sample Testcase:
         * 
         * Linked List = [1→ 0 → 1 → 1 → 0]
         * Answer:
         * 
         * 22
         */

        long ans = 0;
        int n = 0;

        ListNode temp = reverseListNode(head);
        while (temp != null) {

            ans += (temp.data) * (Math.pow(2, n));
            n++;

            temp = temp.next;
        }
        return ans;
    }

    public static String question3(String str) {
        /*
         * A string is provided as an input from console, which consist of integer value
         * Insert '*' if subseqent numbers are even and insert '-' if subsequent numbers
         * are odd
         */
        /*
         * 21462675756 -> 214*6*2*67-5-7-56
         */

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);
            if ((ch1 - '0') % 2 == 0 && (ch2 - '0') % 2 == 0) {
                sb.append(ch1);
                sb.append('*');
            } else if ((ch1 - '0') % 2 != 0 && (ch2 - '0') % 2 != 0) {
                sb.append(ch1);
                sb.append('-');
            } else {
                sb.append(ch1);
            }
        }
        return sb.toString();
    }

    public static void question4(Node head) {
        Node temp = head;
        while (temp.next != null) {
            char ch1 = temp.data;
            char ch2 = temp.next.data;

            if ((ch1 - '0') % 2 == 0 && (ch2 - '0') % 2 == 0) {
                Node newNode = new Node('*');
                newNode.next = temp.next;
                temp.next = newNode;
                temp = temp.next;
            } else if ((ch1 - '0') % 2 != 0 && (ch2 - '0') % 2 != 0) {
                Node newNode = new Node('-');
                newNode.next = temp.next;
                temp.next = newNode;
                temp = temp.next;
            }

            temp = temp.next;
        }
    }

    public static Node convertToLinkedList(String number) {
        Node dummy = new Node('0'); // dummy node to simplify insertion
        Node current = dummy;

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            current.next = new Node(digit);
            current = current.next;
        }

        return dummy.next;
    }

    private static String question5(String string) {
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        System.out.println(list);

        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                sb.append(ch);
            }
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {

        System.out.println(question5("anaadjillddoaaaopppqsbbcccdd"));
        // question5("anaadjillddoaaaopppqsbbcccdd");
    }

    /**
     * Node
     */

}
