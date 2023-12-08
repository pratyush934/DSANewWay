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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("Sorry LinkedList is Empty");
            throw new NullPointerException("Empty LL");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("--<>");
    }

    public void add(int data, int n) { // N -> Index here
        if (n == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        if (head == null) {
            head = tail = null;
        }
        int i = 0;
        Node temp = head;
        while (i < n - 1) {
            if (temp.next == null)
                throw new IndexOutOfBoundsException("Sorry");
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null)
            tail = newNode;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("Sorry LL is EMpty");
            throw new NullPointerException("Empty LL");
        }
        if (head == tail || size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("Sorry LL is EMpty");
            throw new NullPointerException("Empty LL");
        }
        if (head == null || size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        int i = 0;
        while (i < size - 2) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public static int itrSearch(int key) {
        if (head == null) {
            System.out.println("Sorry LL is Empty");
            throw new NullPointerException("Empty LL");
        }

        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public static int recSearch(int key) {
        return recSearchUtil(head, key);
    }

    private static int recSearchUtil(LinkedListRevision.Node head, int key) {
        if (head == null) {
            System.out.println("Sorry LL is Empty");
            throw new NullPointerException("Empty LL");
        }
        if (head.data == key)
            return 0;

        int idx = recSearchUtil(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void reverse(Node head) {
        // 3 variable
        Node prev = null;
        Node curr = head;
        Node next;
        // 4 step
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public int deleteFromNthNode(int n) {
        if (head == null) {
            System.out.println("SOrry");
            throw new NullPointerException("Empty LL");
        }

        if (n == size) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int i = 1;
        Node prev = head;
        while (i < size - n) {
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        return val;
    }

    public Node findMidNode(Node head) {
        if (head == null) {
            System.out.println("Kya Mazak karte ho bhai");
            throw new NullPointerException("Kuch bhi Empty LL hai");
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(Node head) {
        // finding Mid;
        Node mid = findMidNode(head);
        // reversing;
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        // checking every node;

        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }

        return true;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        //detect cycle
        Node fast = head;
        Node slow = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                isCycle = true;
                break;
            }
        }

        if(isCycle == false) return;

        slow = head;
        Node prev = null;
        //meeting point;
        while(fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        //cycle remove
        prev.next = null;
    }

    public void zigZag() {
        //findingMid
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node mid = slow;
        //reversing the half;
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
        Node nextL, nextR;
        //alternate merging
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

    }
}