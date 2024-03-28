package DSA_BOOK.LinkedList;

import java.util.HashMap;

public class Questions {

    public static ListNode head;
    public static ListNode tail;
    public static int size = 0;

    public static int sizeofLL(SinglyList ll) {
        ListNode temp = ll.getHead();
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void clear(SinglyList ll) {
        head = null;
        tail = null;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.data+" -- ");
            head = head.next;
        }
        System.out.println("---");
    }

    /*
     * Problem1 -> Implementing Stacks form LL;
     */

    static class StacksLL {

        public static ListNode headS;
        public static ListNode tailS;

        public StacksLL() {
            headS = null;
            tailS = null;
        }

        public void push(int data) {
            ListNode newNode = new ListNode(data);

            if (headS == null) {
                headS = tailS = newNode;
                return;
            }

            newNode.next = headS;
            headS = newNode;
        }

        public int pop() {

            if (headS == null) {
                System.out.println("So sad, but well tried");
                return -1;
            }

            if (headS == tailS) {
                int val = headS.data;
                headS = tailS = null;
                return val;
            }

            int val = headS.data;
            headS = headS.next;

            return val;
        }

        public int peek() {
            if (head == null) {
                System.out.println("So sad, but well tried");
                return -1;
            }
            return headS.data;
        }

        public boolean isEmpty() {
            return headS == null || tailS == null;
        }

        public int SIZE() {
            ListNode temp = headS;
            int length = 0;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }
    }

    /*
     * Problem 2 and 3 and 4 and 5
     * Our taks is to find Nth node from the end
     */

    public static void problem2and4(SinglyList ll, int n) {
        /*
         * 1. get the size of LL
         * 2. if size < n or size > n check it properly
         */
        int size = sizeofLL(ll);
        // System.out.println(size);
        if (size < n) {
            System.out.println("So sorry");
            return;
        }

        ListNode temp = ll.getHead();
        int i = 0;
        while (temp != null) {
            if (i == size - n) {
                System.out.println("Good going --> 🪬 " + temp.data);
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Nahi chalega nahi chalega");
        /*
         * time complexit -> o(n) + o(n)
         * space complexity -> o(1)
         */
    }

    public static void problem3HashMap(SinglyList ll, int n) {
        int size = sizeofLL(ll);
        if (size < n) {
            System.out.println("So sorry size is not permissible");
            return;
        }
        ListNode temp = ll.getHead();

        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (temp != null) {
            map.put(i++, temp);
            temp = temp.next;
        }

        for (int j : map.keySet()) {
            if (j == size - n) {
                System.out.println("Hurrey mil gaya mere ko mil gaya --->  👁   " + map.get(j).data);
            }
        }

        /*
         * time complexity --> o(n)
         * space complexit --> o(n)
         */
    }

    /*
     * very important and you have to understand this thing
     */
    public static void problem4(SinglyList ll, int n) {
        ListNode pTemp = ll.getHead(), pNthNode = null;
        /*
         * a -> b -> c -> d -> e // n = 2
         */
        for (int i = 1; i < n; i++) {
            pTemp = pTemp.next;
        }

        while (pTemp != null) {
            if (pNthNode == null) {
                pNthNode = ll.getHead();
            } else {
                pNthNode = pNthNode.next;
            }
            pTemp = pTemp.next;
        }
        if (pNthNode != null)
            System.out.println("Mil gaya mil gaya hurrey -> 🏝️  " + pNthNode.data);
        else
            System.out.println("Kya se kya ho gaya");
    }

    /*
     * using the same with recursion
     */
    public static void problem6(ListNode head, int n, int counter) {
        /*
         * will look to it after some time
         */
        if (head != null) {
            problem6(head.next, n, counter);
            counter++;
            if (n == counter) {
                System.out.println("Kya baat kya baat " + head.data);
                return;
            }
        }
        return;
    }

    /*
     * Second set of questions detecting loop
     * it simply means more than one pointer is pointin towards one node
     */

    public static void problem7(SinglyList ll) {

        /*
         * 1st approach is
         * go to each node and see whether more than one node is pointing towards it or
         * not.
         */

        // very difficult
    }

    public static void problem8(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            if (map.containsValue(temp)) {
                System.out.println("hurrey");
                return;
            } else {
                map.put(i++, temp);
            }
        }
        System.out.println("Kya baat hai");
    }

    /*
     * we can not solve this problem with the help of sorting algorithm use
     * commonsense to know the answer
     */

    public static void problem10(ListNode head) {

        ListNode fastPtr = head, slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                System.out.println("Hurrye");
                return;
            }
        }
        System.out.println("Jag suna suna lage");
    }

    public static ListNode problem11(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            slow = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        } else {
            return null;
        }
    }

    public static int problem15(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        int length = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            do {
                slow = slow.next;
                length++;
            } while (fast != slow);
        }

        return length;
    }

    public static ListNode insertInSortedList(ListNode head, ListNode newNode) {
        ListNode current = head;
        ListNode temp = null;

        while (current != null && newNode.data > current.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    /* 
     * 
     * very important question
     */

    /* public static ListNode reverseRecursive(ListNode head) {

    } */

    public static void main(String[] args) {
        
       

        /* ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3; // creates the cycle

        node7.next = node8;
        node8.next = node9;
        node9.next = node6; // completes the cycle

        problem10(node1);
        System.out.println(problem11(node1).data);
        System.out.println(problem15(node1));
         */

        SinglyList ll = new SinglyList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(6);
        // System.out.println(reverseListNode(ll.getHead()));
        print(reverseListNode(ll.getHead()));

    }
}
