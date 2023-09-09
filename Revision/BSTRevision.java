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

    public static Node createBST(int arr[], int start, int end) {

        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;

        /* then go with preorder */
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBSTN(ArrayList<Integer> inorder, int start, int end) {

        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        Node root = new Node(inorder.get(mid));
        root.left = createBSTN(inorder, start, mid - 1);
        root.right = createBSTN(inorder, mid + 1, end);

        return root;

    }

    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node balanceBST(Node root) {
        /* inorder */
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);

        /* sorted inorder --> balanced BST */
        return createBSTN(list, 0, list.size() - 1);
    }

    public static void createBSTProblem() {
        Node root = new Node(8);

        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preorder(balanceBST(root));
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {

        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void anotherBST() {

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBST(root);
        System.out.println(maxBST);
    }

    public static void getInorder1(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        getInorder1(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end) {

        if(start > end) return null;

        int mid = start + (end - start) / 2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2) {
        /* step1 */
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder1(root1, arr1);


        /* step2 */
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder1(root2, arr2);


        /* mergeing List */
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();


        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                list.add(arr1.get(i));
                i++;
            } else {
                list.add(arr2.get(j));
                j++;
            }
        }

        while(i < arr1.size()) {
            list.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()) {
            list.add(arr2.get(j));
            j++;
        }

        /* BST */
        return createBST(list, 0, list.size()-1);

    }

    public static void preOrderN(Node root) {
        if(root == null) return ;

        System.out.print(root.data+" ");
        preOrderN(root.left);
        preOrderN(root.right);
    }

    public static void mergeMerge() {

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        preOrderN(root);
    }

    

    public static void main(String[] args) {
        mergeMerge();
    }
}