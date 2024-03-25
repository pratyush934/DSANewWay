package DSA_BOOK.LinkedList;


public class SinglyList {

  public static ListNode head;
  public static ListNode tail;
  public static int SIZE = 0;

  public static ListNode getHead() {
    return head;
  }

  public static ListNode getTail() {
    return tail;
  }

  public synchronized void addFirst(int data) {
    ListNode newNode = new ListNode(data);
    SIZE++;

    if (head == null) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;
    head = newNode;
  }

  public synchronized void addLast(int data) {
    ListNode newNode = new ListNode(data);
    SIZE++;

    if (head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public synchronized void add(int data, int idx) {
    ListNode newNode = new ListNode(data);
    SIZE++;

    if (idx == 0) {
      addFirst(data);
    } else if (idx == SIZE - 1) {
      addLast(data);
    }

    int i = 0;
    ListNode temp = head;
    while (i < idx - 1) {
      temp = temp.next;
      i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;

  }

  public synchronized int removeFirst() {
    if (head == null) {
      System.out.println("Tumse na ho payega beta");
      return -1;
    }
    if (SIZE == 1) {
      var value = head.data;
      head = tail = null;
      SIZE--;
      return value;
    }

    int value = head.data;
    head = head.next;
    SIZE--;
    return value;
  }

  public synchronized int removeLast() {
    if (head == null) {
      System.out.println("Tumnse na ho payega beta");
      return -1;
    }

    if (SIZE == 1) {
      int value = head.data;
      head = tail = null;
      SIZE--;
      return value;
    }

    ListNode temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    int value = temp.next.data;
    temp.next = null;
    SIZE--;
    tail = temp;

    return value;
  }

  public synchronized void print() {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println("--");
  }

  public synchronized int removeMatched(ListNode value) {
    if (getHead() == null) {
      System.out.println("So Sad that didn't happen");
      return value.data;
    }

    if (value.equals(head)) {
      int val = head.data;
      head = head.next;
      SIZE--;

      return val;
    }

    ListNode temp = head;
    while (!temp.next.equals(value)) {
      temp = temp.next;
    }
    int val = temp.next.data;
    temp.next = temp.next.next;
    SIZE--;

    return val;
  }

  public synchronized int remove(int position) {
    if (head == null) {
      System.out.println("So sad but you can't make it");
      return -1;
    }

    if (position < 0) {
      position = 0;
    }
    if (position > SIZE - 1) {
      position = SIZE - 1;
    }

    int i = 0;
    ListNode prev = head;

    while (i < position - 1) {
      prev = prev.next;
      i++;
    }

    int val = prev.next.data;
    prev.next = prev.next.next;
    SIZE--;

    return val;
  }

  public String toString() {
    String result = "[";
    StringBuffer sb = new StringBuffer();

    if (head == null) {
      result += "]";
    }

    ListNode temp = head;
    while (temp != null) {
      sb.append(temp.data + " ,");
      temp = temp.next;
    }
    result += sb.toString() + " ]";
    return result;
  }

  public int getPosition(int data) {
    int i = 0;
    ListNode temp = head;

    if (temp.data == data) {
      return 0;
    }

    while (temp != null) {
      if (temp.data == data) {
        return i;
      }
      i++;
      temp = temp.next;
    }
    return -1;
  }

  public static void main(String[] args) {
    SinglyList ll = new SinglyList();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.print();
    ll.remove(2);
    ll.print();
    System.out.println(ll.toString());

  }
}