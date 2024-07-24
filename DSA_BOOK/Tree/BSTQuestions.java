package DSA_BOOK.Tree;

public class BSTQuestions {

    public BSTNode find(BSTNode root, int k) {

        if (root == null) {
            return null;
        }

        if (root.data == k) {
            return root;
        } else if (root.data < k) {
            return find(root.right, k);
        } else {
            return find(root.left, k);
        }
    }

    public BSTNode findWithIterative(BSTNode root, int k) {
        if (root == null) {
            return null;
        }

        while (root != null) {

            if (root.data == k) {
                return root;
            } else if (root.data < k) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }

    public BSTNode findMinimum(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMinimum(root.left);
    }

    public BSTNode findMinimunIterative(BSTNode root) {
        if (root == null) {
            return root;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public BSTNode findMax(BSTNode root) {

        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return root;
        }

        return findMax(root.right);

    }

    public BSTNode findMaxIterative(BSTNode root) {

        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public BSTNode inserBstNode(BSTNode root, int val) {
        if (root == null) {
            root = new BSTNode(val);
        } else {
            if (root.data < val) {
                root.right = inserBstNode(root.right, val);
            } else {
                root.left = inserBstNode(root.left, val);
            }
        }
        return root;
    }

    // Bahut Important hai isse jyada kya hi kehna
    public BSTNode deleteNode(BSTNode root, int val) {
        if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else {
            // pakda gaya

            // no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // one child
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }

            // both the child
            BSTNode IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }

        return root;

    }

    public BSTNode inOrderSuccessor(BSTNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
        BSTNode result1 = bstQuestions.find(root, 12);
        System.out.println(bstQuestions.deleteNode(root, 12));
        BSTNode result2 = bstQuestions.find(root, 12);

        System.out.println(result1.data);
        System.out.println(result2);
    }

}
