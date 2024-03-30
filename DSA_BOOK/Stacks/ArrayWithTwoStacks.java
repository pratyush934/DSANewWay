package DSA_BOOK.Stacks;

public class ArrayWithTwoStacks {
    public static int arr[];
    public static int n;
    public int ptr1;
    public int ptr2;

    public ArrayWithTwoStacks(int number) {
        n = number;
        arr = new int[n];
        this.ptr1 = -1;
        this.ptr2 = n;
    }

    public void push1(int data) {
        if (n < 2) {
            System.out.println("Kyu thakk rahe ho , itne me nahi milega thoda size badhao");
            return;
        }
        if (ptr1+1 < n/2 && ptr1 < ptr2) {
            arr[++ptr1] = data;
        } else {
            System.out.println("Left side is full");
        }
    }

    public void push2(int data) {
        if (n < 2) {
            System.out.println("Kyu thakk rahe ho , itne me nahi milega thoda size badhao");
            return;
        }

        if (ptr2 > n/2 && ptr1 < ptr2) {
            arr[--ptr2] = data;
        } else {
            System.out.println("Right side is full");
        }
    }

    public int pop1() {
        if (ptr1 == -1) {
            System.out.println("Khali hai first stack");
            return -1;
        }

        int val = arr[ptr1--];
        return val;
    }

    public int pop2() {
        if (ptr2 == n) {
            System.out.println("Khali hai second stack");
            return -1;
        }

        int val = arr[ptr2++];
        return val;
    }

    public int peek1() {
        if (ptr1 == -1) {
            System.out.println("Khali hai first stack");
            return -1;
        }

        return arr[ptr1];
    }

    public int peek2() {
        if (ptr2 == n) {
            System.out.println("Khali hai second stack🦫");
            return -1;
        }

        return arr[ptr2];
    }

    public boolean isEmpty1() {
        return ptr1 == -1;
    }

    public boolean isEmpty2() {
        return ptr2 == n;
    }

    public String toString1() {
        StringBuffer sb = new StringBuffer();
        while (!isEmpty1()) {
            sb.append(pop1() + "-->");
        }
        return "[ " + sb.toString() + " ]";
    }

    public String toString2() {
        StringBuffer sb = new StringBuffer();
        while (!isEmpty2()) {
            sb.append(pop2() + "-->");
        }
        return "[ " + sb.toString() + " ]";
    }

    public static void main(String[] args) {
        ArrayWithTwoStacks s = new ArrayWithTwoStacks(4);
        s.push1(1);
        s.push1(3);
        s.push1(4);


        s.push2(4);
        s.push2(5);
        s.push2(6);

        System.out.println(s.toString1());
        System.out.println(s.toString2());
    }

}
