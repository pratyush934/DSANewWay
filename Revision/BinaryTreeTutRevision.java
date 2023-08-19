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

    static class BiaryTree {
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
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            System.out.println(-1 + " ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            System.out.println(-1 + " ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            System.out.println(-1 + " ");
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
        /* ISME HUM DIAMETER BHI CALCULATE KARTE CHALENGE HAR EK NODE KA */
        /*
         * SO AGAR KABHI KISI KE SUBTREE ME MAX DIAMETER MILE TO USKO CONSIDER KIYA JA
         * SAKE
         */
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int lDiam = diameter(root.left);
        int rDiam = diameter(root.right);

        return Math.max(lh + rh + 1, Math.max(lDiam, rDiam));
    }

    /* TARIKA NUMBER 2 */
    static class Info {
        int ht;
        int dm;

        public Info(int ht, int dm) {
            this.ht = ht;
            this.dm = dm;
        }
    }

    public static Info diameterInfo(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftDiam = diameterInfo(root.left);
        Info rightDiam = diameterInfo(root.right);

        int diam = Math.max(leftDiam.ht + rightDiam.ht + 1, Math.max(leftDiam.dm, rightDiam.dm));
        int ht = Math.max(leftDiam.ht, rightDiam.ht) + 1;

        return new Info(ht, diam);
    }

    public static boolean isSubtree(Node root, Node subRoot) {

        if (root == null) {
            return false;
        }
        /* IS STEP SE HUME WO ROOT MIL GAYA JA PAR POSSIBILITIES THI */
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        /* YE TAB TAK HOTA RAHEGA JAB TAK HUME MIL NA JAYE WO CHIZ */
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdentical(BinaryTreeTutRevision.Node root, BinaryTreeTutRevision.Node subRoot) {
        /*
         * AGAR ROOT AUR SUBROOT DONO HI NULL HO GAYE TO FALSE (YE AAGE BADHNE KE BAAD
         * KI BAAT HAI)
         */
        if (root == null && subRoot == null) {
            return false;
            /*
             * AGAR AAGE BADHTE BADHTE AISA KOI CASE AA GAYA JAB YE SITUATIONS AAYI HO TO
             * FALSE
             */
        } else if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }

        /* AB LEFT KE LIYE CHECK KARENGE SIMULTANEOUSLY */
        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        /* AB RIGHT KE LIYE CHECK KARENGE SIMULTANEOUSLY */
        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    static class Information {
        int hd;
        Node node;

        public Information(int hd, Node node) {
            this.hd = hd;
            this.node = null;
        }
    }

    public static void topView(Node root) {
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        q.add(new Information(0, root));
        q.add(null);

        int min = 0, max = 0; /* FOR TRACKING THE LIMITS FOR ITERATION IN THE MAP , HOWEVER NOT NECESSARY */

        while (!q.isEmpty()) {
            Information currInfo = q.remove();
            if (currInfo == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(currInfo.hd)) {
                    map.put(currInfo.hd, currInfo.node);
                }
                if (currInfo.node.left != null) {
                    q.add(new Information(currInfo.hd - 1, currInfo.node));
                    min = Math.min(currInfo.hd, min);
                }
                if (currInfo.node.right != null) {
                    q.add(new Information(currInfo.hd + 1, currInfo.node));
                    max = Math.max(currInfo.hd, max);
                }
            }
        }
        for (Integer key : map.keySet()) {
            System.out.print(map.get(key) + " "+ " ");
        }

    }

    public static void kLevel(Node root, int level, int K) {
        if (root == null) {
            return;
        }
        if (level == K) {
            System.out.print(root.data + " ");
            return;
        }
        kLevel(root.left, level + 1, K);
        kLevel(root.right, level + 1, K);
    }

    public static int KAncestor(Node root, int N, int K) {
        if (root == null) {
            return 0;
        }
        if (root.data == N) {
            return 0;
        }
        int leftDist = KAncestor(root.left, N, K);
        int rightDist = KAncestor(root.right, N, K);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == K) {
            System.out.println(root.data + " ");
        }
        return max + 1;
    }

    public static int transFormtoSumTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = transFormtoSumTree(root.left);
        int rightSum = transFormtoSumTree(root.right);
        int data = root.data;
        int newLeft = root == null ? 0 : root.left.data;
        int newRight = root == null ? 0 : root.right.data;

        root.data =  leftSum + rightSum + newLeft + newRight;
        return data;
    }

    public static void main(String[] args) {

    }
}