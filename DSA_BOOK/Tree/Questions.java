package DSA_BOOK.Tree;

import java.lang.runtime.TemplateRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
        if(root == null) {
            return false;
        }
        if(root.data == data) {
            return true;
        }

        return isAvialble(root.left, data) || isAvialble(root.right, data);
    }

    public boolean isAvialbleIterative(BinaryTreeNode root, int data) {
        if(root == null) {
            return false;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if(temp.data == data) {
                return true;
            }

            if(temp != null) {
                if(temp.left != null) {
                    q.add(temp.left);
                }

                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return false;
    }

    public boolean isAvialbleIterativeUsingStack(BinaryTreeNode root, int data) {
        if(root == null) {
            return false;
        }

        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            BinaryTreeNode b = s.pop();

            if(b.data == data) {
                return true;
            }

            if(b.right != null) {
                s.push(b.right);
            }

            if(b.left != null) {
                s.push(b.left);
            }
        }
        return false;
    }

    public static BinaryTreeNode insertNode(BinaryTreeNode root, int data) {
        if(root == null) {
            return new BinaryTreeNode(data);
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();

            if(temp != null) {
                if(temp.left != null) {
                    q.add(temp.left);
                } else {
                    temp.left = new BinaryTreeNode(data);
                    return root;
                }

                if(temp.right != null) {
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
        if(root == null) {
            root = new BinaryTreeNode(data);
        } else {
            insertNodeRecursiveHelper(root, data);
        }
    }

    public static void insertNodeRecursiveHelper(BinaryTreeNode root, int data) {

        if(data > 100) {

            if(root.left == null) {
              root.left = new BinaryTreeNode(data);
            } else {
              insertNodeRecursiveHelper(root.left, data);
            }
        } else {
            if(root.right == null) {
                root.right = new BinaryTreeNode(data);
            } else {
                insertNodeRecursiveHelper(root.right, data);
            }
        }

    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(15);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(13);
        root.right.right = new BinaryTreeNode(25);

        Questions questions = new Questions();
        questions.preOrder(root);
        insertNodeRecursiveHelper(root, 90);
        System.out.println();
        questions.preOrder(root);
        // questions.inOrder(ans);
    }
}
