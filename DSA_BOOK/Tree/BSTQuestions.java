package DSA_BOOK.Tree;

import java.util.Queue;

public class BSTQuestions {

    public BSTNode find(BSTNode root, int k) {

        if(root == null) {
            return null;
        }

        if(root.data == k) {
            return root;
        } else if(root.data < k) {
            return find(root.right, k);
        } else {
            return find(root.left, k);
        }
    }

    public BSTNode findWithIterative(BSTNode root, int k) {
        if(root == null) {
            return null;
        }

        while(root != null) {

            if(root.data == k) {
                return root;
            } else if(root.data < k) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        BSTNode root = new BSTNode(10);
        root.left = new BSTNode(5);
        root.right = new BSTNode(15);
        root.left.left = new BSTNode(2);
        root.left.right = new BSTNode(7);
        root.right.left = new BSTNode(12);
        root.right.right = new BSTNode(18);

        BSTQuestions bstQuestions = new BSTQuestions();
        int searchKey = 7;
        BSTNode result = bstQuestions.findWithIterative(root, searchKey);

        if (result != null) {
            System.out.println("Node with key " + searchKey + " found.");
        } else {
            System.out.println("Node with key " + searchKey + " not found.");
        }
    }
}
