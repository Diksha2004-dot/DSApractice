public class SubtreeOfAnotherTree {

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

    public static boolean isSymmetric(Node root, Node subroot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subroot)) {
            return true;
        }
        return isSymmetric(root.left, subroot) || isSymmetric(root.right, subroot);
    }

    public static boolean isSame(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null || root.val != subroot.val) {
            return false;
        }
        return isSame(root.left, subroot.left) && isSame(root.right, subroot.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right = new Node(3);

        Node root2 = new Node(2);
        root2.left = new Node(4);
        root2.right = new Node(5);

        System.out.println(isSymmetric(root1, root2));
    }
}