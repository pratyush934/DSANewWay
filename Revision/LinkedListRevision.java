public class LinkedListRevision {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void print() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("*");
    }

    public static int removeFirst() {
        if (head == null) {
            System.out.println("Sorry LL is Empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast() {
        if (head == null) {
            System.out.println("Sorry LL is Empty");
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        int i = 0;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int val = temp.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public static int itrSearch(int key) {
        if (head == null) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int recSearch(int key) {
        return recSearchUtil(head, key);
    }

    private static int recSearchUtil(LinkedListRevision.Node head, int key) {
        if (head == null) {
            System.out.println("LL is Empty");
            return Integer.MAX_VALUE;
        }
        if (head.data == key)
            return 0;

        int idx = recSearchUtil(head.next, key);

        if (idx == -1)
            return -1;

        return idx + 1;
    }

    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static int deleteFromNthNode(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            sz++;
            temp = temp.next;
        }

        if(sz == n) {
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
        int i = 1;
        temp = head;
        while(i < sz-n) {
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    public static Node findMNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head) {

        /* findMidNode */
        Node mid = findMNode(head);

        /* reverse */
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        /* check */
        while(right != null) {
            if(right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return;

        Node prev = null;
        slow = head;

        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }
    public static void main(String[] args) {

    }
}