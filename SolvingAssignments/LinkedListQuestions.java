package SolvingAssignments;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQuestions {

    public static void Question1(Node head1, Node head2) {
        Node fast = head1;
        Node slow = head2;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast.next == slow.next) {
                System.out.println("Milan wala address and data is " + fast.next + " " + fast.next.data);
                break;
            }
        }
    }

    public static Node Question1Technique2(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return temp;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static int QuestionTechnique3(Node head1, Node head2) {
        int l1 = 0, l2 = 0;
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }

        if (l1 > l2) {
            int n = l1 - l2;
            temp1 = head1;
            temp2 = head2;
            for (int i = 0; i < n; i++) {
                temp1 = temp1.next;
            }
            while (temp1 != null) {
                if (temp1.data == temp2.data) {
                    return temp1.data;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return -1;
        } else {
            int n = l2 - l1;
            temp1 = head1;
            temp2 = head2;
            for (int i = 0; i < n; i++) {
                temp2 = temp2.next;
            }
            while (temp2 != null) {
                if (temp2.data == temp1.data) {
                    return temp2.data;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return -1;
        }
    }

    

    public static void main(String[] args) {

    }

}
