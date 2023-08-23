
/* Ctrl + Shift + I --> for linux */
/* Alt + Shift + F --> for windows */

import java.util.HashMap;
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
        if (root == null) {
            new DiameterInfo(0, 0);
        }
        DiameterInfo lDiam = diameterInfo(root.left);
        DiameterInfo rDiam = diameterInfo(root.right);

        int ht = Math.max(lDiam.ht, rDiam.ht) + 1;
        int diam = Math.max(lDiam.ht + rDiam.ht + 1, Math.max(lDiam.diam, rDiam.diam));

        return new DiameterInfo(ht, diam);
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdentical(BinaryTreeTutRevision.Node root, BinaryTreeTutRevision.Node subRoot) {
        /* INSTEAD OF YE DEKHNE KI KAHA KAHA HAI YE DEKHO KI KAHA NAHI HAI */
        if (root == null && subRoot == null)
            return false;

        else if (root == null || subRoot == null || root.data != subRoot.data)
            return false;

        if (!isIdentical(root.left, subRoot.left))
            return false;

        if (!isIdentical(root.right, subRoot.right))
            return false;

        return true;
    }

    static class InfoTopView {
        int hd;
        Node node;

        public InfoTopView(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void topView(Node root) {
        Queue<InfoTopView> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        q.add(new InfoTopView(0, root));
        q.add(null);

        int max = 0, min = 0;

        while (!q.isEmpty()) {
            InfoTopView curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd))
                    map.put(curr.hd, curr.node);

                if (curr.node.left != null) {
                    q.add(new InfoTopView(curr.hd - 1, curr.node.left));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new InfoTopView(curr.hd + 1, curr.node.right));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for (Integer key : map.keySet()) {
            System.out.print(map.get(key).data + " ");
        }
    }

    public static void kLevel(Node root, int k, int level) {
        if(root == null) {
            return ;
        }
        if(level == k) {
            System.out.print(root.data+" ");
            return;
        }
        kLevel(root, k, level+1);
        kLevel(root, k, level-1);
    }

    public static void main(String[] args) {

        System.out.println("Hello");
    }
}