package DSA_BOOK.LinkedList;

public class CircularLL {
    public static CLLNode head;
    public static CLLNode tail;

    public synchronized int SIZE() {
        CLLNode temp = head.next;
        int length = 0;
        while (temp != head) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public synchronized void addFirst(int data) {
        CLLNode newNode = new CLLNode(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    public synchronized void addLast(int data) {
        CLLNode newNode = new CLLNode(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public synchronized void add(int data, int position) {

        CLLNode newNode = new CLLNode(data);

        if (position == 0) {
            addFirst(data);
        } else if (position == SIZE() - 1) {
            addLast(data);
        }

        CLLNode temp = head;
        int i = 0;
        while (i < position - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public synchronized int removeFirst() {
        if (head == null) {
            System.out.println("So sad but well tried");
            return -1;
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        tail.next = head;

        return val;
    }

    public synchronized int removeLast() {
        if (head == null) {
            System.out.println("So sad but well tried");
            return -1;
        }

        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        CLLNode temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = temp.next.next;
        tail = temp;
        return val;
    }

    public synchronized int remove(int position) {
        if (position == 0) {
            return removeFirst();
        } else if (position == SIZE() - 1) {
            return removeLast();
        }

        int i = 0;
        CLLNode temp = head;
        while (i < position - 1) {
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    public synchronized boolean contains(int data) {
        CLLNode temp = head;
        while (temp.next != head) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public synchronized boolean contains(CLLNode node) {
        CLLNode temp = head;
        while (temp.next != head) {
            if (temp.equals(node)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public synchronized boolean isEmpty() {
        return tail == null || head == null;
    }

    public synchronized void clear() {
        head = null;
        tail = null;
    }

    public synchronized String toString() {
        StringBuffer sb = new StringBuffer();
        CLLNode temp = tail.next;
        while (temp != tail) {
            sb.append(temp.data + ",");
            temp = temp.next;
        }
        sb.append(temp.data);
        return "[" + sb.toString() + "]";
    }

    public synchronized void print() {
        CLLNode temp = tail.next;
        while (temp != tail) {
            System.out.print(temp.data + "---");
            temp = temp.next;
        }
        System.out.print(temp.data + "---");
        System.out.println("👌");

    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(4);
        cll.print();
        System.out.println(
                cll.toString()
        );

    }
}
