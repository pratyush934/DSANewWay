package DSA_BOOK.LinkedList;

public class SinglyList {

  public static ListNode head;
  public static ListNode tail;
  public static int size;

  public SinglyList() {
    head = null;
    tail = null;
    size = 0;
  }

  public synchronized void addFirst(int data) {

    ListNode newNode = new ListNode(data);
    size++;

    if (head == null) {
      head = newNode;
      return;
    }

    newNode.next = head;
    head = newNode;
  }

  public synchronized void addLast(int data) {

    ListNode newNode = new ListNode(data);
    size++;

    ListNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }

    temp.next = newNode;
    tail = newNode;
  }

  public synchronized void add(int data, int n) {

    if (n == 0) {
      addFirst(data);
      return;
    }

    else if (n == size - 1) {
      addLast(data);
      return;
    }

    ListNode newNode = new ListNode(data);
    size++;

    int i = 0;
    ListNode temp = head;
    while (i < n - 1) {
      temp = temp.next;
      i++;
    }

    newNode.next = temp.next;
    temp.next = newNode;

  }

  public synchronized void printLinkedList(ListNode head) {

    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println("**");

  }

  public synchronized int removeFirst(ListNode head) {

    if (head == null) {
      System.out.println("Sorry the LinkedList is Empty");
      return -1;
    }

    if (size == 1) {
      int val = head.data;
      head = null;
      return val;
    }

    else {
      int val = head.data;
      head = head.next;
      return val;
    }
  }

  public synchronized int removeLast(ListNode head) {
    if (head == null) {
      System.out.println("Sorry the LinkedList is Empty");
      return -1;
    }

    if (size == 1) {
      int val = head.data;
      head = null;
      return val;
    }

    else {
      ListNode temp = head;
      while (temp.next.next != null) {
        temp = temp.next;
      }

      int val = temp.next.data;
      temp.next = null;

      return val;
    }
  }

  public synchronized int removeNth(ListNode head, int pos) {
    if (pos == 0) {
      return removeFirst(head);
    } else if (pos == size - 1) {
      return removeLast(head);
    } else {
      ListNode prev = head;
      ListNode temp = head;
      int i = 0;
      while (i < pos) {
        prev = temp;
        temp = temp.next;
        i++;
      }
      int val = temp.data;
      prev.next = temp.next;
      temp.next = null;
      return val;
    }
  }

  public synchronized void removeMathched(ListNode node) {
    
  }

}