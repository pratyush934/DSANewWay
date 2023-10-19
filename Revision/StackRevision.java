import java.util.ArrayList;

public class StackRevision {

    static class StacksArrayList {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void add(int data) {
            list.add(data);
        }

        public int pop() {
            if(isEmpty()) {
                System.out.println("Stack Is Empty");
                return -1;
            }
            return list.remove(list.size()-1);
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    
    public static void main(String[] args) {
        
    }
}