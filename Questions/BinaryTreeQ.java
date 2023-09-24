package Questions;


import java.util.ArrayList;

public class BinaryTreeQ {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if(root != null) {
            list.add(root.data);
            list.addAll(preOrder(root.left));
            list.addAll(preOrder(root.right));
        }
        return list;
    }

    public static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if(root != null) {
            list.addAll(inOrder(root.left));
            list.add(root.data);
            list.addAll(inOrder(root.right));
        }
        return list;
    }

    public static ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if(root != null) {
            list.addAll(postOrder(root.left));
            list.addAll(postOrder(root.right));
            list.add(root.data);
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}