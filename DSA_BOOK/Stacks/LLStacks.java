package DSA_BOOK.Stacks;

import DSA_BOOK.LinkedList.ListNode;

public class LLStacks {
    public static ListNode head;
    public static ListNode tail;
    private static int size;

    public LLStacks() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            System.out.println("Kya baat hai magar chapp nahi sakta");
            return -1;
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Kya baat hai kya baat hai");
            return -1;
        }
        return head.data;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.data + "--->");
            temp = temp.next;
        }
        return "[" + sb.toString() + "]";
    }

    public static void main(String[] args) {
        LLStacks s = new LLStacks();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.toString());
    }
}
