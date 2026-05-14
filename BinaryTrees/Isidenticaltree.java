public class Isidenticaltree{
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

    public static boolean isSame(Node p,Node q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }

    public static void main(String[]args){
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);


        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println(isSame(root1, root2));
    }
}