package SolvingAssignments;

import DSA_BOOK.LinkedList.ListNode;

public class JPMogran {
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
         * Insert '*' if subseqent numbers are even and insert '-' if subsequent numbers are odd
         */
        /* 
         * 21462675756  -> 214*6*2*67-5-7-56
         */

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length()-1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            if((ch1-'0') % 2 == 0 && (ch2 - '0') % 2 == 0 ) {
                sb.append(ch1);
                sb.append('*');
            } else if((ch1-'0') % 2 != 0 && (ch2 - '0') % 2 != 0) {
                sb.append(ch1);
                sb.append('-');
            } else {
                sb.append(ch1);
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        // String[] arr = {
        //         "saw", "hammer", "mallet",
        //         "file", "saw", "ladder", "scissor"
        // };

        // System.out.println(question1(arr, "princi", 6));

        /* ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);
        
        System.out.println(question2(head)); */

        System.out.println(question3("21462675756"));
    }


}
