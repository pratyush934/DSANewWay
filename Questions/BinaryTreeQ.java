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

        if (root != null) {
            list.add(root.data);
            list.addAll(preOrder(root.left));
            list.addAll(preOrder(root.right));
        }
        return list;
    }

    public static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            list.addAll(inOrder(root.left));
            list.add(root.data);
            list.addAll(inOrder(root.right));
        }
        return list;
    }

    public static ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            list.addAll(postOrder(root.left));
            list.addAll(postOrder(root.right));
            list.add(root.data);
        }
        return list;
    }

    public static boolean isBalancedTree(Node root) {
        /*
         * Given a binary tree, find if it is height balanced or not.
         * A tree is height balanced if difference between heights of left and right
         * subtrees is not more than one for all nodes of tree
         */

        if(root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if(lh - rh < 1) return false;

        return isBalancedTree(root.left) && isBalancedTree(root.right);
        
    }

    private static int height(Node root) {
        if(root == null)
        return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}