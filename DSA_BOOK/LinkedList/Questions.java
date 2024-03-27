package DSA_BOOK.LinkedList;


public class Questions {

    public static ListNode head;
    public static ListNode tail;
    public static int size = 0;

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
            }
            return length;
        }
    }

    /* 
     * Problem 2 and 3 and 4 and 5
     * Our taks is to find Nth node from the end
     */
    

    public static void main(String[] args) {
        StacksLL s = new StacksLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }    
}
