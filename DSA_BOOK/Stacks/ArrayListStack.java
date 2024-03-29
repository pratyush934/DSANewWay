package DSA_BOOK.Stacks;

import java.util.ArrayList;

public class ArrayListStack {
    public static ArrayList<Integer> list;
    
    public ArrayListStack() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Kya baat hai kya baat hai pr tumse na ho payega");
            return -1;
        } else {
            return list.remove(list.size() - 1);
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Kya baat hai kya baat hai pr tumse na ho payega");
            return -1;
        } else {
            return list.get(list.size() - 1);
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.remove(i) + "--->");
        }
        return "[ " + sb.toString() + " ]";
    }

    public static void main(String[] args) {
        ArrayListStack s = new ArrayListStack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.toString());
    }
}
