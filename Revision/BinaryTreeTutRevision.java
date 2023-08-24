import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import BinaryTreeTut.Information;

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

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            size++;
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
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
                System.out.print(curr.data + " ");
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

        return Math.min(lh + rh + 1, Math.max(lDiam, rDiam));
    }

    static class InfoDiameter {
        int ht;
        int diam;

        public InfoDiameter(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static InfoDiameter diameterInfo(Node root) {
        if (root == null) {
            new InfoDiameter(0, 0);
        }
        InfoDiameter lDiam = diameterInfo(root.left);
        InfoDiameter rDiam = diameterInfo(root.right);

        int diam = Math.max(lDiam.ht + rDiam.ht + 1, Math.max(lDiam.diam, rDiam.diam));
        int ht = Math.max(lDiam.ht, rDiam.ht) + 1;

        return new InfoDiameter(ht, diam);
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isIdentical(BinaryTreeTutRevision.Node root, BinaryTreeTutRevision.Node subRoot) {
        /* INSTEAD OF CHECKING FOR IDENTICAL CHECK FOR NON-IDENTICAL */
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
        Node node;
        int hd;

        public InfoTopView(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();

        Queue<InfoTopView> q = new LinkedList<>();
        q.add(new InfoTopView(root, 0));
        q.add(null);

        int min = 0, max = 0;
        
        while(!q.isEmpty()) {
            InfoTopView curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new InfoTopView(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null) {
                    q.add(new InfoTopView(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for (Integer keyInteger : map.keySet()) {
            System.out.print(map.get(keyInteger).data+" ");
        }
    }

    public static void main(String[] args) {

    }
}