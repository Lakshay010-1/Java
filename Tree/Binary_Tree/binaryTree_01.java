package Tree.Binary_Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class binaryTree_01 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Info{
        int height;
        int diameter;

        Info(int diameter,int height){
            this.height=height;
            this.diameter=diameter;
        }
    }
    static class Status{
        Node nRoot;
        int horDis;
        Status(Node nRoot,int horDis){
            this.nRoot=nRoot;
            this.horDis=horDis;
        }
    }
    static class BinaryTree{
        //Build tree using pre-order
        static int idx=-1;
        public static Node buildTreePre(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode =new Node(nodes[idx]);
            newNode.left=buildTreePre(nodes);
            newNode.right=buildTreePre(nodes);
            return newNode;
        }

        //tree traversals
        //(i). Pre-order
        public static void preOrderTrl(Node root){
            if(root==null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");
            preOrderTrl(root.left);
            preOrderTrl(root.right);            
        }
        //(ii). In-order
        public static void inOrderTrl(Node root){
            if(root==null){
                System.out.print("-1 ");
                return;
            }
            inOrderTrl(root.left);
            System.out.print(root.data+" ");
            inOrderTrl(root.right);
        }
        //(iii). Post-Order
        public static void postOrderTrl(Node root){
            if(root==null){
                System.out.print("-1 ");
                return ;
            }
            postOrderTrl(root.left);
            postOrderTrl(root.right);
            System.out.print(root.data+" ");
        }
        //(iv). Level Order
        public static void levelOrderTrl(Node root){
            if(root==null){
                return ;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode!=null){
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                    
                }
                else{                    
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
            }
        }

        //Height of the tree
        public static int heightTree(Node root){
            if(root==null){
                return 0;
            }
            int leftHeight=heightTree(root.left);
            int rightHeight=heightTree(root.right);
            int height=Math.max(leftHeight,rightHeight)+1;
            return height;
        }

        //Total nodes in the tree
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftCount=countNodes(root.left);
            int rightCount=countNodes(root.right);
            int count=leftCount+rightCount+1;
            return count;
        }

        //sum total of data in nodes in tree
        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum=sumNodes(root.left);
            int rightSum=sumNodes(root.right);
            int sum=leftSum+rightSum+root.data;
            return sum;
        }

        //diameter of the tree{unoptimised} ~0(n^2)
    public static int diameterBTuo(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        int leftHeight=heightTree(root.left);
        int rightHeight=heightTree(root.right);
        int diameter=Math.max(Math.max(leftHeight+rightHeight+1,leftCount),rightCount);
        return diameter;
    }

    

    //diameter of the tree{optimised} ~0(n)
    public static Info diameterBTo(Node root){
        if(root==null){
            return (new Info(0,0));
        }
        Info leftInfo=diameterBTo(root.left);
        Info rightInfo=diameterBTo(root.right);
        int dia=Math.max(leftInfo.diameter,Math.max(rightInfo.diameter, leftInfo.height+rightInfo.height+1));
        int hgt=Math.max(leftInfo.height,rightInfo.height)+1;
        return(new Info(dia, hgt));
    }

    //check if given root is actually the a sub-root of the main tree root
    public static boolean isSubTree(Node root,Node subroot){
        if(root==null){
            return false;
        }

        if(root.data==subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        boolean leftCond=isSubTree(root.left, subroot);
        boolean rightCond=isSubTree(root.right, subroot);
        return leftCond||rightCond;
    }

    public static boolean isIdentical(Node root,Node subroot){
        if(root==null && subroot==null){
            return true;
        }
        else if(root==null && subroot!=null){
            return false;
        }
        else if(root!=null && subroot==null){
            return true;
        }
        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }

    //top view of a tree
    public static void topView(Node root){
        Queue<Status> q=new LinkedList<>();
        int min=0,max=0;        
        HashMap<Integer,Node> map=new HashMap<>();
        q.add(new Status(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Status curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.horDis)){
                    map.put(curr.horDis, curr.nRoot);
                }
                if(curr.nRoot.left!=null){
                    q.add(new Status(curr.nRoot.left, curr.horDis-1));
                    min=Math.min(min,curr.horDis-1);
                }
                if(curr.nRoot.right!=null){
                    q.add(new Status(curr.nRoot.right, curr.horDis+1));
                    max=Math.max(max,curr.horDis+1);
                }
            }   
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }


    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};        
        //buildTree
        Node root=tree.buildTreePre(nodes);
        System.out.println(root.data);
        //traversal
        System.out.println("preorder");
        tree.preOrderTrl(root);
        System.out.println();
        System.out.println("inorder");
        tree.inOrderTrl(root);
        System.out.println();
        System.out.println("PostOrder");
        tree.postOrderTrl(root);
        System.out.println();
        System.out.println("Level Order");
        tree.levelOrderTrl(root);
        //height
        System.out.println(tree.heightTree(root));
        //Total Nodes
        System.out.println(tree.countNodes(root));
        //sum total of nodes
        System.out.println(tree.sumNodes(root));
        //diameter of the tree
        System.out.println("diameter (unoptimised) = "+tree.diameterBTuo(root));
        Info diameterO=tree.diameterBTo(root);
        System.out.println("diameter (optimised) = "+diameterO.diameter);
        int treee[]={1,2,3,-1,-1,4,-1,-1,5,-1,6,-1,-1};
        tree.idx=-1;
        Node root1=tree.buildTreePre(treee);
        System.out.println(root1.data);
        int subtree[]={2,3,-1,-1,4,-1,-1};
        tree.idx=-1;
        Node root2=tree.buildTreePre(subtree);
        System.out.println(root2.data);
        int subtree2[]={5,-1,6,-1,-1};
        tree.idx=-1;
        Node root3=tree.buildTreePre(subtree2);
        System.out.println(root3.data);
        int subtree3[]={5,-1,6,-1,1,-1,-1};
        tree.idx=-1;
        Node root4=tree.buildTreePre(subtree3);
        System.out.println(root4.data);
        System.out.println(tree.isSubTree(root1,root2));
        //System.out.println(tree.isSubTree(root1,root3));
        System.out.println(tree.isSubTree(root1,root4));
        tree.topView(root1);
                
    }
    
}
