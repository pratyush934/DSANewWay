package Questions;


import java.util.ArrayList;

public class BSTQuestions {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int minValue(Node root) {
        /*
         * Given a Binary Search Tree.
         * The task is to find the minimum valued element in this given BST.
         */

        if (root == null)
            return -1;
        else if (root.left == null)
            return root.data;
        else
            return minValue(root.left);
    }

    public static boolean searchBST(Node root, int key) {
        /*
         * Given a Binary Search Tree and a node value X,
         * find if the node with value X is present in the BST or not.
         */

        if (root == null)
            return false;

        if (root.data == key)
            return true;
        else if (root.data > key)
            return searchBST(root.left, key);
        else
            return searchBST(root.right, key);
    }

    public static void sortedArrayToBSTrec(int nums[], ArrayList<Integer> list , int start, int end) {
        if(start > end) 
        return;

        int mid = start + (end - start) / 2;
        list.add(nums[mid]);
        sortedArrayToBSTrec(nums, list, start, mid-1);
        sortedArrayToBSTrec(nums, list, mid+1, end);
    }
    public static int[] sortedArrayToBST(int nums[]) {
        int ans[] = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();

        sortedArrayToBSTrec(nums, list, 0, nums.length-1);

        for(int i=0; i<ans.length; i++) {
            ans[i] = list.get(i);
        }
        list.clear();
        return ans;
    }

    public static void main(String[] args) {

    }
}