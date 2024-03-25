package DSA_BOOK.LinkedList;

public class DLLNode {

    public int data;
    public DLLNode prev;
    public DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public DLLNode getPrev() {
        return prev;
    }
    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }
    public DLLNode getNext() {
        return next;
    }
    public void setNext(DLLNode next) {
        this.next = next;
    }

}
