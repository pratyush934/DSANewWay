package Questions;

public class TreeQuestion {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void mirrorNode(Node root) {
        if(root == null) return;

        mirrorNode(root.left);
        mirrorNode(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
