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
    }


}