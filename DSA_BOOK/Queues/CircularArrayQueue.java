
public class CircularArrayQueue {

    private static int queue[];
    private static int CAPACITY;
    private static int rear;
    private static int front;

    public CircularArrayQueue(int n) {
        CAPACITY = n;
        queue = new int[n];
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % CAPACITY == front;
    }

    public void enque(int data) {
        if (isFull()) {
            System.out.println("Na hoga humse from enque");
            return;
        }

        /*
         * Ye line na hone ke karan error aa raha tha
         */
        if (front == -1)
            front = 0;

        rear = (rear + 1) % CAPACITY;
        queue[rear] = data;
    }

    public int deque() {
        if (isEmpty()) {
            System.out.println("Na hoga humse from deque");
            return -1;
        }
        if (front == -1) {
            front = (front + 1) % CAPACITY;
        }

        int value = queue[front];
        if (front == rear) {
            front = rear - 1;
        } else {
            front = (front + 1) % CAPACITY;
        }
        return value;
    }

    public int peek() {

        if (isEmpty()) {
            System.out.println("Kya baat hai , but na hoga tumse");
            return -1;
        }

        return queue[front];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < CAPACITY; i++) {
            sb.append(queue[i] + "-->");
        }
        sb.append("🍌");

        return "[ " + sb.toString() + " ]";
    }

    public static void main(String[] args) {
        CircularArrayQueue q = new CircularArrayQueue(3);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        // q.enque(4);

        System.out.println(q.toString());
    }

}
