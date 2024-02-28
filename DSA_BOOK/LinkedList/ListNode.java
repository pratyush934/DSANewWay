package DSA_BOOK.LinkedList;

public class ListNode {

  int data;
  ListNode next;

  public ListNode(int data) {
    this.data = data;
    this.next = null;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getData() {
    return this.data;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode getNext() {
    return this.next;
  }
}