import DSA_BOOK.LinkedList.ListNode;

public class LinkedListQueue {

    private static ListNode head;
    private static ListNode tail;
    private static int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public int size() {
        return size;
    }

    public void enque(int data) {
        ListNode newNode = new ListNode(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int deque() {
        if (head == tail) {
            int value = head.data;
            head = tail = null;
            return value;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    public int peek() {
        if (head == null) {
            System.out.println("Empty from peek");
            return -1;
        }

        return head.data;
    }

    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.enque(1);
        q.enque(2);
        q.enque(3);

        while(!q.isEmpty()) {
            System.out.print(q.peek()+"-->");
            q.deque();
        }

        
    }

}
