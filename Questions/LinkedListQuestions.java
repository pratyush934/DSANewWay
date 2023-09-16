import java.util.ArrayList;
import java.util.HashSet;

public class LinkedListQuestions {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int countNodes(Node head) {
        /**
         * Given a linked list of size N.
         * The task is to complete the function countNodesinLoop() that checks
         * whether a given Linked List contains a loop or not and if the loop is
         * present then return the count of nodes in a loop or else return 0.
         * C is the position of the node to which the last node is connected.
         * If it is 0 then no loop.
         */

        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int count = 1;
                slow = slow.next;

                while (slow != fast) {
                    slow = slow.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }

    public static Node interSectionNode(Node head1, Node head2) {
        /**
         * Given two linked lists sorted in increasing order,
         * create a new linked list representing the intersection of the two linked
         * lists.
         * The new linked list should be made with its own memory the original lists
         * should not be changed.
         * Note: The linked list elements are not necessarily distinct.
         */
        Node newNode = new Node(0);
        Node ans = newNode;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                ans.next = new Node(temp1.data);
                ans = ans.next;
                temp1 = temp2.next;
                temp2 = temp2.next;
            } else if (temp1.data < temp2.data) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }
        return newNode.next;
    }

    public static Node interSectionNode1(Node head1, Node head2) {
        /*
         * Given two linked lists, the task is to complete the function
         * findIntersection(),
         * that returns the intersection of two linked lists.
         * Each of the two linked list contains distinct node values.
         */
        HashSet<Integer> set = new HashSet<>();

        Node newNode = new Node(0);
        Node ans = newNode;

        Node temp = head1;
        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }

        temp = head2;
        while (temp != null) {
            if (set.contains(temp.data)) {
                ans.next = temp;
                ans = ans.next;
            }
            temp = temp.next;
        }
        ans.next = null;
        return newNode.next;
    }

    public static Node unionNodes(Node head1, Node head2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head1;
        while (temp != null) {
            set.add(temp.data);
        }
        temp = head2;
        while (temp != null) {
            set.add(temp.data);
        }

        for (Integer i : set) {
            list.add(i);
        }
        Node newNode = new Node(0);
        Node ans = newNode;

        for (int i = 0; i < list.size(); i++) {
            ans.next = new Node(list.get(i));
            ans = ans.next;
        }
        list.clear();
        return newNode.next;
    }

    public static long multiplyNodes(Node head1, Node head2) {
        /**
         * Given elements as nodes of the two linked lists. The task is to multiply
         * these two linked lists, say L1 and L2.
         * 
         * Note: The output could be large take modulo 109+7.
         */
        long num1 = 0;
        long num2 = 0;
        long mod = (long) Math.pow(10, 9) + 7;

        Node temp = head1;
        while (temp != null) {
            num1 = ((num1 * 10) + temp.data) % mod;
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            num2 = ((num2 * 10) + temp.data) % mod;
            temp = temp.next;
        }
        return (num1 * num2) % mod;
    }

    public static int firstNodeofCycle(Node head) {
        /*
         * Given a singly linked list of N nodes. Find the first node of the loop if the
         * linked list has a loop. If a loop is present return the node data of the
         * first node of the loop else return -1.
         */

        Node slow = head;
        Node fast = head;
        
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return -1;

        slow = head;
        // Node prev = null;

        while(slow != fast) {
            // prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {

    }
}
