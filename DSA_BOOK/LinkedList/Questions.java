package DSA_BOOK.LinkedList;


public class Questions {

    public static ListNode head;
    public static ListNode tail;
    public static int size = 0;

    public static int sizeofLL() {
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void clear() {
        head = null;
        tail = null;
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

            if(headS == null) {
                headS = tailS = newNode;
                return;
            }

            newNode.next = headS;
            headS = newNode;
        }

        public int pop() {

            if(headS == null) {
                System.out.println("So sad, but well tried");
                return -1;
            }

            if(headS == tailS) {
                int val = headS.data;
                headS = tailS = null;
                return val;
            }

            int val = headS.data;
            headS = headS.next;

            return val;
        }

        public int peek() {
            if(head == null) {
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
            while(temp != null) {
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

    public static void problem2BruteForce(SinglyList ll, int n) {
        /* 
         * 1. get the size of LL
         * 2. if size < n or size > n check it properly 
         */
        int size = sizeofLL();
        if(size > n) {
            System.out.println("So sorry");
            return ;
        }

        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            if(i == size-n) {
                System.out.println("Good going" + temp.data);
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Nahi chalega nahi chalega");
    }


    public static void main(String[] args) {
        SinglyList ll = new SinglyList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        problem2BruteForce(ll, 3);       
    }    
}
