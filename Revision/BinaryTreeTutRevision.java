
/* Ctrl + Shift + I --> for linux */
/* Alt + Shift + F --> for windows */

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTutRevision {

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

    static class BinaryTree {
        static int idx = -1;
        static int size = 0;

        public static Node buildBinaryTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            size++;
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            System.out.println("Sorry Root has null value");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(root.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lCount = countNodes(root.left);
        int rCount = countNodes(root.right);
        return lCount + rCount + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lSum = sumOfNodes(root.left);
        int rSum = sumOfNodes(root.right);
        return lSum + rSum + root.data;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int lDiam = diameter(root.left);
        int rDiam = diameter(root.right);

        return Math.max(lh + rh + 1, Math.max(lDiam, rDiam));
    }

    static class DiameterInfo {
        int ht;
        int diam;

        public DiameterInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static DiameterInfo diameterInfo(Node root) {
        if(root == null) {
            new DiameterInfo(0, 0);
        }
        DiameterInfo lDiam = diameterInfo(root.left);
        DiameterInfo rDiam = diameterInfo(root.right);

        int ht = Math.max(lDiam.ht, rDiam.ht) + 1;
        int diam = Math.max(lDiam.ht+rDiam.ht+1, Math.max(lDiam.diam, rDiam.diam));

        return new DiameterInfo(ht, diam);
    }

    public static void main(String[] args) {

        System.out.println("Hello");
    }
}