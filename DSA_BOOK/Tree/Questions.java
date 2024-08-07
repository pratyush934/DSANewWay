package DSA_BOOK.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Questions {

    public void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.data + "-->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data + "-->");
            inOrder(root.right);
        }
    }

    public void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + "-->");
        }
    }

    public List<Integer> preOrderIterative(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            BinaryTreeNode temp = s.pop();

            list.add(temp.data);

            if (temp.right != null) {
                s.push(temp.right);
            }

            if (temp.left != null) {
                s.push(temp.left);
            }
        }

        return list;
    }

    public List<Integer> inOrderTraversalIterative(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode temp = root;
        s.push(root);
        while (!s.isEmpty()) {

            if (temp.left != null) {
                s.push(temp.left);
                temp = temp.left;
            } else {
                if (s.isEmpty()) {
                    break;
                } else {
                    list.add(s.pop().data);
                    temp = temp.right;
                }
            }
        }
        return list;
    }

    public List<Integer> postOrderTraversalIterative(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            BinaryTreeNode temp = s.pop();

            list.add(temp.data);

            if (temp.left != null) {
                s.push(temp.left);
            }

            if (temp.right != null) {
                s.push(temp.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> levelOrderTraversal(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.poll();

            if (node == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                list.add(node.data);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return list;
    }

    public static int MAX = Integer.MIN_VALUE;

    public int maxInBinaryTree(BinaryTreeNode root) {

        if (root != null) {

            int leftMax = maxInBinaryTree(root.left);
            int rightMax = maxInBinaryTree(root.right);

            if (leftMax > rightMax) {
                MAX = leftMax;
            } else {
                MAX = rightMax;
            }

            if (root.data > MAX) {
                MAX = root.data;
            }
        }

        return MAX;

    }

    public int maxInBinaryTreeIterative(BinaryTreeNode root) {

        // In the case if we are using stack all elements won't be traversed

        Queue<BinaryTreeNode> q = new LinkedList<>();

        q.offer(root);
        int max = -1110;
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if (temp.data > MAX) {
                max = temp.data;
            }

            if (temp != null) {
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
        return max;
    }

    public boolean isAvialble(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        return isAvialble(root.left, data) || isAvialble(root.right, data);
    }

    public boolean isAvialbleIterative(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if (temp.data == data) {
                return true;
            }

            if (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return false;
    }

    public boolean isAvialbleIterativeUsingStack(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }

        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            BinaryTreeNode b = s.pop();

            if (b.data == data) {
                return true;
            }

            if (b.right != null) {
                s.push(b.right);
            }

            if (b.left != null) {
                s.push(b.left);
            }
        }
        return false;
    }

    public static BinaryTreeNode insertNode(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data);
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                } else {
                    temp.left = new BinaryTreeNode(data);
                    return root;
                }

                if (temp.right != null) {
                    q.add(temp.right);
                } else {
                    temp.right = new BinaryTreeNode(data);
                    return root;
                }
            }
        }

        return root;
    }

    public static void insertNodeRecursive(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            insertNodeRecursiveHelper(root, data);
        }
    }

    public static void insertNodeRecursiveHelper(BinaryTreeNode root, int data) {

        if (data > 100) {

            if (root.left == null) {
                root.left = new BinaryTreeNode(data);
            } else {
                insertNodeRecursiveHelper(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new BinaryTreeNode(data);
            } else {
                insertNodeRecursiveHelper(root.right, data);
            }
        }
    }

    public int size(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = size(root.left);
        int rh = size(root.right);

        return lh + rh + 1;
    }

    public int sizeWithIterative(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<BinaryTreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            BinaryTreeNode temp = q.poll();

            if (temp != null) {
                count++;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        return count;
    }

    public List<Integer> preOrderReverse(BinaryTreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<BinaryTreeNode> s = new Stack<>();

        s.push(root);

        while (!s.isEmpty()) {

            BinaryTreeNode temp = s.pop();

            list.add(temp.data);

            if (temp.left != null) {
                s.push(temp.left);
            }

            if (temp.right != null) {
                s.push(temp.right);
            }
        }
        return list;
    }

    public int maxDepthInBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthInBinaryTree(root.left);
        int rightDepth = maxDepthInBinaryTree(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepthInBinaryTreeIterative(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if (temp == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    count++;
                } else {
                    return count + 1;
                }
            } else {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return count;
    }

    public int minDepthOfBinaryTree(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        int count = 1;

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            BinaryTreeNode temp = q.poll();

            if (temp == null) {

                if (!q.isEmpty()) {
                    count++;
                    q.add(null);
                }

            } else {

                if (temp.left == null && temp.right == null) {
                    return count;
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return count;
    }

    public int maxDepthOfBinaryTree(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE;

        int count = 1;
        Queue<BinaryTreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            BinaryTreeNode curr = q.poll();

            if (curr != null) {
                if (curr.left == null && curr.right == null) {
                    max = Math.max(count, max);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else {
                if (q.isEmpty()) {
                    return max;
                } else {
                    count++;
                    q.add(null);
                }
            }
        }
        return max;
    }

    public int maxDepthNode(BinaryTreeNode root) {
        if (root == null) {
            return -1;
        }
        BinaryTreeNode curr = null;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            curr = q.poll();

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return curr.data;
    }

    public int numberOfLeafNode(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            BinaryTreeNode curr = q.poll();

            if (curr.left == null && curr.right == null) {
                count++;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return count;
    }

    public int numberofFullNodes(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        int count = 0;

        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();

            if (curr.left != null && curr.right != null) {
                count++;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return count;
    }

    public int numberOfHalfNodes(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        int count = 0;

        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();

            if (curr.left != null && curr.right == null) {
                count++;
            }

            if (curr.right != null && curr.left == null) {
                count++;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return count;
    }

    public boolean isIdenticalStructurally(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return isIdenticalStructurally(root1.left, root2.right) || isIdenticalStructurally(root1.right, root2.left);
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameterInfo(BinaryTreeNode root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info left = diameterInfo(root.left);
        Info right = diameterInfo(root.right);

        int lh = Math.max(left.ht, right.ht) + 1;
        int diam = Math.max(Math.max(left.diam, right.diam), left.ht + right.ht + 1);

        return new Info(lh, diam);
    }

    public int findLevelWithMaxSum(BinaryTreeNode root) {
        int maxSum = 0;
        int currSum = 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            BinaryTreeNode currNode = q.poll();

            if (currNode == null) {

                if (q.isEmpty()) {
                    return maxSum;
                } else {
                    maxSum = Math.max(maxSum, currSum);
                    currSum = 0;
                    q.add(null);
                }

            } else {
                currSum += currNode.data;

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        return maxSum;
    }

    public void printPath(BinaryTreeNode root) {
        int arr[] = new int[256];
        printPathHelper(root, arr, 0);
    }

    public void printArray(int arr[], int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printPathHelper(BinaryTreeNode root, int arr[], int index) {
        if (root == null) {
            return;
        }
        arr[index] = root.data;
        index++;

        if (root.left == null && root.right == null) {
            printArray(arr, index);
        } else {
            printPathHelper(root.left, arr, index);
            printPathHelper(root.right, arr, index);
        }
    }

    public int sumOfNodes(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public boolean hasPathSum(BinaryTreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.data == sum) {
            return true;
        } else
            return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    public int sumOfNodesIterative(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();

            sum += curr.data;

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return sum;
    }

    public BinaryTreeNode mirrorTree(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        if (root == null) {

            return null;

        } else {

            mirrorTree(root.left);
            mirrorTree(root.right);

            // swapping
            temp = root.left;
            root.left = root.right;
            root.right = temp;

        }
        return root;

    }

    public boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return isMirror(root1.left, root2.right) || isMirror(root1.right, root2.left);
    }

    public BinaryTreeNode treeFromPreOrderAndInorder(int preOrder[], int inOrder[]) {

        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        return treeFromPreOrderAndInorderHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /*
     * Very Important -> Very Important
     */
    public BinaryTreeNode treeFromPreOrderAndInorderHelper(int preOrder[], int preStart, int preEnd, int inOrder[],
            int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int data = preOrder[preStart];
        BinaryTreeNode curr = new BinaryTreeNode(data);

        int offSet = inStart;
        for (; offSet < inEnd; offSet++) {
            if (inOrder[offSet] == data) {
                break;
            }
        }

        curr.left = treeFromPreOrderAndInorderHelper(preOrder, preStart + 1, preStart + offSet - inStart, inOrder,
                inStart, offSet - 1);
        curr.right = treeFromPreOrderAndInorderHelper(preOrder, preStart + offSet - inStart + 1, preEnd, inOrder,
                offSet + 1, inEnd);

        return curr;
    }

    // very important
    public boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
        if (root == null) {
            return false;
        }

        if (root.left == node || root.right == node || printAllAncestors(root.left, node)
                || printAllAncestors(root.right, node)) {
            System.out.print(root.data + "-->");
            return true;
        }
        return false;
    }

    public BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {

        if (root == null) {
            return root;
        }

        if (root == a || root == b) {
            return root;
        }

        BinaryTreeNode left = lca(root.left, a, b);
        BinaryTreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    public List<Integer> zigZagTraversal(BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {

            int n = q.size();
            List<Integer> temp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {

                BinaryTreeNode curr = q.poll();

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

                if (leftToRight)
                    temp.add(curr.data);
                else
                    temp.add(0, curr.data);
            }
            leftToRight = !leftToRight;
            list.addAll(temp);
        }
        return list;

    }

    public void verticalSumHelper(BinaryTreeNode root, Map<Integer, Integer> map, int c) {

        if (root.left != null) {
            verticalSumHelper(root.left, map, c - 1);
        }
        if (root.right != null) {
            verticalSumHelper(root.right, map, c + 1);
        }

        int data = 0;
        if (map.containsKey(c)) {
            data = map.get(c);
        }
        map.put(c, data + root.data);

    }

    public void verticalSum(BinaryTreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        verticalSumHelper(root, map, 0);
        for (int i : map.keySet()) {
            System.out.println(i + "-->" + map.get(i));
        }
    }

    public BinaryTreeNode buildTreeFromPreOrder(int[] A, int i) {
        /*
         * ILILL -> 10100
         * tee ke liye preOrder/postOrder ke saath Inorder bhi chaiye
         * lekin isme do nodes honge compulsory
         */
        if (A == null) {
            return null;
        }
        if (A.length == i) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.data = A[i];
        node.left = null;
        node.right = null;

        if (A[i] == 0) {
            return node;
        }
        i++;
        node.left = buildTreeFromPreOrder(A, i);
        i++;
        node.right = buildTreeFromPreOrder(A, i);

        return node;

    }



    public static void main(String[] args) {

        /*
         * BinaryTreeNode root = new BinaryTreeNode(10);
         * root.left = new BinaryTreeNode(2);
         * root.right = new BinaryTreeNode(15);
         * root.left.left = new BinaryTreeNode(1);
         * root.left.right = new BinaryTreeNode(5);
         * root.right.left = new BinaryTreeNode(13);
         * root.right.right = new BinaryTreeNode(25);
         * 
         * Questions questions = new Questions();
         * System.out.println(questions.minDepthOfBinaryTree(root));
         */

        /*
         * BinaryTreeNode root = new BinaryTreeNode(1);
         * root.left = new BinaryTreeNode(2);
         * root.right = new BinaryTreeNode(3);
         * root.left.left = new BinaryTreeNode(4);
         * root.left.right = new BinaryTreeNode(5);
         * root.right.left = new BinaryTreeNode(6);
         * root.right.right = new BinaryTreeNode(7);
         * 
         * 
         * Questions questions = new Questions();
         * System.out.println(questions.lca(root, root.left.right,
         * root.right.left).data);
         */

        /*
         * BinaryTreeNode root1 = new BinaryTreeNode(1);
         * root1.left = new BinaryTreeNode(4);
         * root1.right = new BinaryTreeNode(3);
         * 
         * // Initialize the second binary tree (identical to the first)
         * BinaryTreeNode root2 = new BinaryTreeNode(1);
         * root2.left = new BinaryTreeNode(2);
         * root2.right = new BinaryTreeNode(3);
         * 
         * // Instantiate Questions class
         * Questions questions = new Questions();
         * 
         * // Assert that isIdentical returns true for identical trees
         * System.out.println(questions.isIdenticalStructurally(root1, root2));
         */

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        // Step 2: Create an instance of the class containing zigZagTraversal
        Questions questions = new Questions();

        // Step 3: Call zigZagTraversal and print the result
        // List<Integer> result = questions.zigZagTraversal(root);
        // System.out.println(result); // Exp
        questions.verticalSum(root);

    }

}
