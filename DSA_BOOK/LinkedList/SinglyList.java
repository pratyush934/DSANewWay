package DSA_BOOK.LinkedList;

public class SinglyList {

  public static ListNode head;
  public static ListNode tail;
  public static int size = 0;

  public synchronized void ListNode(int data) {
    ListNode newNode = new ListNode(data);
    size++;

    if (head == null) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;
    head = newNode;
  }

  public synchronized void addLast(int data) {
    ListNode newNode = new ListNode(data);
    size++;

    if (head == null) {
      head = tail = newNode;
      return;
    }

    tail.next = newNode;
    tail = newNode;
  }

  public synchronized void print() {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + "-->");
      temp = temp.next;
    }
    System.out.println("---");

    /* 
     * for(; temp != null; temp = temp.next) {
     *  sout(temp.data)
     * }
     */

  }

  public static void main(String[] args) {

  }
}