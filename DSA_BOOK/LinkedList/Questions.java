package DSA_BOOK.LinkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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

    public static int sizeofLL(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static void clear(SinglyList ll) {
        head = null;
        tail = null;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -- ");
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

        while (current != null) {
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

    /*
     * public static ListNode reverseRecursive(ListNode head) {
     * 
     * }
     */

    public static ListNode yIntersection(ListNode head1, ListNode head2) {
        /*
         * a -> b -> c -> d -> e
         * f -> g ---^
         */

        /*
         * brute force -> compare each and every node prolem 18
         * double iteration
         */

        /*
         * we can not use sorting technique as it does not make any sense
         */

        HashMap<Integer, ListNode> map1 = new HashMap<>();

        int i = 0;
        while (head1 != null) {
            map1.put(i++, head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (map1.containsValue(head2)) {
                return head2;
            }
            head2 = head2.next;
        }

        return null;
    }

    public static ListNode yIntersection2(ListNode head1, ListNode head2) {
        /*
         * Using STACKS
         * 1. Stack1 and Stack2
         * 2. push one by one to stack1 and stack2
         * 3. compare both of them from the top until they are same and store s.pop()
         * until last equal element appears
         * 4. traversing will be from back of the stack
         */

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (head1 != null) {
            s1.push(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            s2.push(head2);
            head2 = head2.next;
        }

        ListNode transition = null;

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() == s2.peek()) {
                transition = s1.peek();
                s1.pop();
                s2.pop();
            } else {
                break;
            }
        }
        return transition;
    }

    public static ListNode yIntersection3(ListNode head1, ListNode head2) {
        /*
         * the most efficient method
         */

        /*
         * Algo
         * 1. length of List1 and List2 n and m
         * 2. looking for difference setting temps according to it.
         * 3. my goal here is to bring the pointer at same level
         * 4. now move both the pointer till the reach the same
         */

        ListNode temp1 = head1, temp2 = head2;
        int size1 = sizeofLL(head1);
        int size2 = sizeofLL(head2);
        int diff = 0;

        if (size1 > size2) {
            temp1 = head1;
            temp2 = head2;
            diff = size1 - size2;
        } else {
            temp1 = head2;
            temp2 = head1;
            diff = size2 - size1;
        }

        for (int i = 0; i < diff; i++) {
            temp1 = temp1.next;
        }

        while (temp1 != null && temp2 != null) {
            if (temp1.equals(temp2)) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }

    /*
     * Very important pattern
     * finding the mid of the ll
     */

    public static ListNode middleNode(ListNode head1) {
        int size = sizeofLL(head1);

        int i = 1;
        while (head1 != null) {
            if (i == size / 2) {
                if (size % 2 == 0) {
                    return head1;
                } else {
                    return head1.next;
                }
            }
            i++;
            head1 = head1.next;
        }

        return null;
    }

    public static ListNode middleNode1(ListNode head1) {
        /**
         * two pointer approach very important
         */

        ListNode ptr1 = head1, ptr2 = head1;
        int i = 0;
        while (ptr1.next != null) {
            if (i == 0) {
                ptr1 = ptr1.next;
                i = 1;
            } else {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                i = 0;
            }
        }
        return ptr2;
    }

    public static void printListFromEnd(ListNode head) {
        if (head == null) {
            return;
        }
        printListFromEnd(head.next);
        System.out.print(head.data + "<--");
    }

    public static int lengthOfLLEvenorOdd(ListNode head) {
        /*
         * very important as time complexity O(n/2)
         */
        while (head != null && head.next != null) {
            head = head.next.next;
        }
        if (head == null)
            return 0; // even

        return 1; // odd
    }

    public static ListNode mergeSortIterative(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return head.next;
    }

    public static ListNode mergeLLRecursive(ListNode head1, ListNode head2) {
        ListNode current = new ListNode(0);
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        if (head1.data <= head2.data) {
            current.next = head1;
            current.next.next = mergeLLRecursive(head1.next, head2);
        } else {
            current.next = head2;
            current.next.next = mergeLLRecursive(head1, head2.next);
        }

        return current.next;
    }

    public static ListNode reverseInPair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = head.next.next;
        temp.next = head;
        head = temp;

        head.next.next = reverseInPair(head.next.next);

        return head;

    }

    public static ListNode reverseInPairIterative(ListNode head) {
        ListNode temp1 = null;
        ListNode temp2 = null;

        while (head != null && head.next != null) {

            if (temp1 != null) {
                temp1.next.next = head.next;
            }

            temp1 = head.next;
            head.next = head.next.next;
            temp1.next = head;

            if (temp2 == null) {
                temp2 = temp1;
            }

            head = head.next;
        }
        return temp2;
    }

    public static boolean isPalindrome(ListNode head) {
        //find mid;
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        ListNode mid = slowPtr;
        //reverse half of it
        ListNode next;
        ListNode current = mid;
        ListNode previous = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode left = head;
        ListNode right = previous;
        //check one by one
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {

        /*
         * // Create the first linked list
         * ListNode list1 = new ListNode(1);
         * ListNode temp1 = list1;
         * temp1.next = new ListNode(3);
         * temp1 = temp1.next;
         * temp1.next = new ListNode(5);
         * 
         * // Create the second linked list
         * ListNode list2 = new ListNode(2);
         * ListNode temp2 = list2;
         * temp2.next = new ListNode(4);
         * temp2 = temp2.next;
         * temp2.next = new ListNode(6);
         */

        ListNode head = new ListNode(1);
        ListNode temp = head;

        // Insert elements in the list
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(6);

        System.out.println((isPalindrome(head)));

    }
}
