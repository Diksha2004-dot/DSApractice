import java.util.*;
public class TopViewofTree{
         
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

     static class Info{
        int hd;
        Node node;
        public Info(Node node,int hd){
             this.node=node;
            this.hd=hd;
           
        }
     }

     public static void Topview(Node root){
  Queue<Info>q=new LinkedList<>();
  HashMap<Integer,Node>map=new HashMap<>();
   int min=0;
   int max=0;
  q.add(new Info(root,0));
 
  while(!q.isEmpty()){
    Info curr=q.remove();
    if(!map.containsKey(curr.hd)){
        map.put(curr.hd,curr.node);
    }
    if(curr.node.left!=null){
        q.add(new Info(curr.node.left,curr.hd-1));
        min=Math.min(min,curr.hd-1);
    }
        if(curr.node.right!=null){
        q.add(new Info(curr.node.right,curr.hd+1));
        max=Math.max(max,curr.hd+1);
    }

  }
  for(int i=min ;i<=max;i++){
    System.out.print(map.get(i).val +" ");
  }
     }
    
       public static void main(String[]args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        Topview(root);
       
    }
}