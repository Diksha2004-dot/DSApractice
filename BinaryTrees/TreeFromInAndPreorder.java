
import java.util.*;

public class TreeFromInAndPreorder {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int preorderidx = 0;

    public static Node construct(int[] inorder, int[] preorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);

    }

    public static Node helper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        Node root = new Node(preorder[preorderidx++]);
        int idx = map.get(root.val);
        root.left = helper(preorder, left, idx - 1);
        root.right = helper(preorder, idx + 1, right);
        return root;
    }

    public static void print(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] preorder = { 3, 9, 20, 15, 7 };
        Node root = construct(inorder, preorder);
        print(root);
    }
}