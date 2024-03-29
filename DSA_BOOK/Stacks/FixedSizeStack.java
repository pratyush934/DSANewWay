package DSA_BOOK.Stacks;

public class FixedSizeStack {
    public int capacity;
    public int arr[];
    public int rear;

    public FixedSizeStack(int n) {
        this.capacity = n;
        this.arr = new int[n];
        this.rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void push(int data) {
        if (rear == capacity - 1) {
            System.out.println("Stack is Full and can not be filled completely");
            return;
        } else {
            arr[++rear] = data;
        }
    }

    public int pop() {
        if (rear == -1) {
            System.out.println("Stack is Empty and can not take any data from it");
            return -1;
        }
        int data = arr[rear--];
        return data;
    }

    public int peek() {
        if (rear == -1) {
            System.out.println("Stack is Empty and can not show any value");
            return -1;
        }
        return arr[rear];
    }

    public int sizeofFixedArray() {
        return rear + 1;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int index = rear; index >= 0; index--) {
            sb.append(arr[index] + "-->");
        }
        return "[ " + sb.toString() + " ]";

    }

    public static void main(String[] args) {
        FixedSizeStack s = new FixedSizeStack(4);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.toString());
    }
}
