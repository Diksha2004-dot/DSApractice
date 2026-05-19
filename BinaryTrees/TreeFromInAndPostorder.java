import java.util.HashMap;

public class TreeFromInAndPostorder {
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
    static int postorderidx = 0;

    public static Node construct(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int postorderidx = postorder.length - 1;
        return helper(postorder, 0, inorder.length - 1);

    }

    public static Node helper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        Node root = new Node(postorder[postorderidx--]);
        int idx = map.get(root.val);

        root.right = helper(postorder, idx + 1, right);
        root.left = helper(postorder, left, idx - 1);
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
        int[] postorder = { 9, 15, 7, 20, 3 };
        Node root = construct(inorder, postorder);
        print(root);
    }
}
