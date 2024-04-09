
public class StaticQueue {
    private int[] queue;
    private int CAPACITY;
    private int rear;

    public StaticQueue(int n) {
        CAPACITY = n;
        queue = new int[CAPACITY];
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == CAPACITY - 1;
    }

    public void enque(int data) {
        if (isFull()) {
            throw new Error("Is Full");
        }
        queue[++rear] = data;
    }

    public int deque() {
        if (isEmpty()) {
            throw new Error("Empty");
        }
        int value = queue[0];
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new Error("Empty from peek");
        }
        return queue[0];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < queue.length; i++) {
            sb.append(queue[i] + "->");
        }
        sb.append("🐱");
        return "[ " + sb.toString() + " ]";
    }

    public static void main(String[] args) {
        StaticQueue s = new StaticQueue(3);
        s.enque(1);
        s.enque(2);
        s.enque(3);

        System.out.println(s.toString());
    }
}