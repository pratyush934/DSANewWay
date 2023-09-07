import java.util.ArrayList;

public class BSTRevision {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean searchBST(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        } else if (root.data > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            /* case - 1 */
            if (root.left == null && root.right == null)
                return null;

            /* case - 2 */
            if (root.right == null)
                return root.left;

            else if (root.left == null)
                return root.right;

            /* case - 3 */
            /* two children */
            Node IS = findLeftMostNode(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    private static BSTRevision.Node findLeftMostNode(BSTRevision.Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void basicImplementation() {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();
        Node deletedNodes = delete(root, 1);
        System.out.println(deletedNodes.data);
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size());
    }

    public static Node mirrorNode(Node root) {

        if (root == null)
            return null;

        Node leftMirror = mirrorNode(root.left);
        Node rigthMirror = mirrorNode(root.right);

        root.left = rigthMirror;
        root.right = leftMirror;

        return root;
    }

    public static void main(String[] args) {

    }
}