package DSA_BOOK.LinkedList;


public class DoublyList {

    public static DLLNode head;
    public static DLLNode tail;
    public static int SIZE;

    public synchronized void addFirst(int data) {
        DLLNode newNode = new DLLNode(data);
        SIZE++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public synchronized void addLast(int data) {
        DLLNode newNode = new DLLNode(data);
        SIZE++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    public synchronized void add(int data, int position) {
        DLLNode newNode = new DLLNode(data);
        SIZE++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        DLLNode previous = head;
        int i = 0;
        while(i < position - 1) {
            previous = previous.next;
            i++;
        }
        newNode.next = previous.next;
        previous.next.prev = newNode;
        previous.next = newNode;
        newNode.prev = previous;

    }

    public synchronized int removeFirst() {
        if(head == null) {
            System.out.println("Good Going but it is not practically possible");
            return -1;
        }

        if(head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head.next.prev = null;
        head = head.next;
        SIZE--;

        return val;
    }

    public synchronized int removeLast() {
        if(head == null) {
            System.out.println("SOrry , we have failed you");
            return -1;
        }

        if(head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        DLLNode previous = head;
        while(previous.next.next != null)  {
            previous = previous.next;
        }
        int val = previous.next.data;
        previous.next.prev = null;
        previous.next = null;
        tail = previous;
        SIZE--;

        return val;
    }

    public synchronized int remove(int position) {
        if(position == 0) {
            return removeFirst();
        } else if(position == SIZE-1) {
            return removeLast();
        }

        DLLNode previous = head;
        int i = 0;
        while(i < position-1) {
            previous = previous.next;
            i++;
        }

        int val = previous.next.data;
        previous.next.next.prev = previous;
        previous.next = previous.next.next;
        SIZE--;
        return val;

    }

    public String toString() {
        
        StringBuffer sb = new StringBuffer();

        DLLNode temp = head;
        while(temp != null) {
            sb.append(temp.data+",");
            temp = temp.next;
        }

        
        return "[ " + sb.toString() + " ]";
    }

    public synchronized void print() {
        DLLNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+"<-->");
            temp = temp.next;
        }
        System.out.println("**");
    }

    public static void main(String[] args) {
        DoublyList dll = new DoublyList();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.add(5, 1);
        dll.print();
        dll.remove(1);
        dll.print();
        System.out.println(dll.toString());
    }


}