
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
        System.out.println("**");
    }

    public static void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        int i = 0;
        Node newNode = new Node(data);
        size++;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static int removeFirst() {
        if (head == null) {
            System.out.println("Sorry , LL is Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public static int removeLast() {
        if (head == null) {
            System.out.println("Sorry, LL is Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }
        int i = 0;
        Node temp = head;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int value = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return value;
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
        if (head.data == key) {
            return 0;
        }
        int idx = recSearchUtil(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static int deleteFromNthNode(int n) {
        Node temp = head;
        int sz = 0;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }
        if (sz == n) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int i = 1;
        temp = head;
        while (i < sz - n) {
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

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome() {
        /* findMidNode */
        Node mid = findMNode(head);
        /* reverse */
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;

        /* checking */
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

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
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) {
            return ;
        }
        Node prev = null;
        while(fast != null) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static void zigZag() {
        /* findMidNode */
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow;
        /* reverse and Break the palindrome */
        Node curr = mid.next;
        mid.next = null; /* breaking the ll */
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        /* printing zigZag */

        Node right = prev;
        Node left = head;
        Node nextR, nextL;

        while(left.next != null && right.next != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            right = nextR;
            left = nextL;
        }

    }
    public static void main(String[] args) {

    }
}