package Binary_Tree;
import java.util.LinkedList;
import java.util.Queue;

public class biTree_01 {
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




        
    }
    
}
