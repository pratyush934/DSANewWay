import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTut {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
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

        public static void preOrder(Node root) {
            /* root will be in top */
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            /* root will be in middle */
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            /* root will be in last */
            if (root == null) {
                System.out.print(-1 + " ");
                return;
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
                Node curNode = q.remove();

                if (curNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curNode.data + " ");
                    if (curNode.left != null) {
                        q.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        q.add(curNode.right);
                    }
                }
            }

        }
    }

    public static void accessing1() {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(nodes);
        System.out.println(root.data);
        BinaryTree.preOrder(root);
        System.out.println();
        BinaryTree.inOrder(root);
        System.out.println();
        BinaryTree.postOrder(root);
    }

    public static void accessing2() {
        /* level order Traversal */
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.levelOrder(root);
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
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
        return lc + rc + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lSum = sumOfNodes(root.left);
        int rSum = sumOfNodes(root.right);
        return lSum + rSum + root.data;
    }

    public static int diameter(Node root) { /* O(N) */
        if (root == null) {
            return 0;
        }
        int lDiam = diameter(root.left);
        int rDiam = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh + rh + 1, Math.max(rDiam, lDiam));
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameterInfo(Node root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterInfo(root.left);
        Info righInfo = diameterInfo(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.ht + righInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, righInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void accessing3() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        /*
         * true -> if subtree
         */
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        // boolean leftAns = isSubtree(root.left, subRoot);
        // boolean rightAns = isSubtree(root.right, subRoot);
        // return leftAns || rightAns;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static void accessing4() {
        /*
         * Parent Node
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         * Sub-Tree
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }

    static class Information {
        Node node;
        int hd;

        public Information(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void TopView(Node root) {
        /* level Order */
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Information(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Information curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);

                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void KLevel(Node root, int level, int K) {
        if (root == null) {
            return;
        }
        if (level == K) {
            System.out.print(root.data + " ");
            return;
        }
        KLevel(root.left, level + 1, K);
        KLevel(root.right, level + 1, K);
    }

    public static void accessing5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        KLevel(root, 1, 3);
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<BinaryTreeTut.Node> path1 = new ArrayList<>();
        ArrayList<BinaryTreeTut.Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }

    private static boolean getPath(BinaryTreeTut.Node root, int n, ArrayList<Node> path) {
        if (root == null)
            return false;
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2)
            return root;

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        /* leftLCA(valid) rightLCA null */
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    private static int lcaDist(BinaryTreeTut.Node root, int n) {
        if (root == null)
            return -1;

        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist); /* MAX IS USED HERE FOR JUST MAXIMUM VALUE */
        if (max + 1 == k) { 
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static int transFormtoSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transFormtoSumTree(root.left);
        int righChild = transFormtoSumTree(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + righChild;

        return data;
    }

    public static void preOrder1(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder1(root.left);
        preOrder1(root.right);
    }

    public static void accessing6() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println(KAncestor(root, 5, 2));
        // KAncestor(root, 5, 2);
        transFormtoSumTree(root);
        preOrder1(root);
    }

    public static void main(String[] args) {
        accessing6();
    }
}
