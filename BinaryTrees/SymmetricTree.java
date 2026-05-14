public class SymmetricTree{

    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isSymmetric(Node t1,Node t2){
        if(t1==null && t2==null){
            return true;
        }
        if(t1==null || t2==null) {
            return false;
        }
        return t1.val==t2.val && isSymmetric(t1.left,t2.right)&& isSymmetric(t1.right,t2.left);
    }
    public static void main(String[] args) {
         Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root, root));
    }
}