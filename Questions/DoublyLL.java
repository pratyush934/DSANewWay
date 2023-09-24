package Questions;


public class DoublyLL {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static Node sortedInsert(Node head, int data) {
    /*
     * Question : 
     * Given a sorted doubly linked list and 
     * an element X, your need to insert the element X 
     * into correct position in the sorted DLL.
     */

        Node temp = head;
        Node newNode = new Node(data);

        /* starting end */
        if(temp.data >= data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        /* ending */
        temp = head;
        Node tail = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
        if(tail.data <= data) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            newNode.next = null;
            return head;
        }
        /* middle */
        while(temp.data <= data) {
            temp = temp.next;
        }
        Node previous = temp.prev;
        previous.next = newNode;
        newNode.next = temp;
        temp.prev = newNode;
        newNode.prev = previous;

        return head;
    }
    
    public static void main(String[] args) {
        
    }
}