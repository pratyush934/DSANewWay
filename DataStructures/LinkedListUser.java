import java.util.LinkedList;

public class LinkedListUser {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(Node head) {
        if(head == null) {
            System.out.println("LL is Empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("*");
    }
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node prev = head;
        int i = 0;
        while(i < idx-1) {
            prev = prev.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }
    public static int removeFirst(Node head) {
        if(head == null) {
            System.out.println("LL is Empty");
            return Integer.BYTES;
        } else if(size == 1) {
            int var = head.data;
            head = tail = null;
            size--;
            return var;
        }
        int var = head.data;
        head = head.next;
        size--;
        return var;
    }
    public static int removeLast(Node head) {
        if(head == null) {
            System.out.println("LL is Empty");
            return Integer.BYTES;
        } else if(size == 1) {
            int var = head.data;
            head = tail = null;
            size--;
            return var;
        }
        Node prev = head;
        int i = 0;
        while(i < size-2) {
            prev = prev.next;
            i++;
        }
        int var = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return var;
    }
    public static int itrSearch(int key) {
        if(head == null) {
            System.out.println("LL is Empty");
            return -1;
        }
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    private static int recSearchUtil(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = recSearchUtil(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public static int recSearch(int key) {
        return recSearchUtil(head, key);
    }
    public void reverse(Node head) {
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
        Node temp = head;
        int sz = 0;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(sz == n) {
            int var = head.data;
            head = tail = null;
            return var;
        }
        int i = 1;
        Node prev = head;
        while(i < sz-n) {
            prev = prev.next;
            i++;
        }
        int var = prev.next.data;
        prev.next = prev.next.next;
        return var;
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
    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Node mid = findMNode(head);

        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

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
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -> last.next = null;
        prev.next = null;
    }

    public void zigZag() {
        /* find mid */
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        /* reverse 2nd half */
        Node curr = mid.next;
        mid.next = null; // 2 parts me todne ke liye
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        /* alt merge - zig-zag merge */
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }
    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
        
    }
    
}