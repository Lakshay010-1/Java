package Binary_Tree;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class biTree_02 {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
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

    //print nodes on kth level of the tree
    public static void printKth(Node root,int k,int L){
        if(root==null){
            return;
        }
        if(L==k){
            System.out.print(root.data+" ");
        }
        printKth(root.left, k, L+1);
        printKth(root.right, k, L+1);
    }

    //lowest common ancestor
    //approach 1
    public static int lca1(Node root,int n1,int n2){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        ArrayList<Integer> path1=new ArrayList<>();
        ArrayList<Integer> path2=new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        
        int i=0;
        for(;i<path1.size() &&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }
    public static boolean getPath(Node root,int n,ArrayList<Integer> path){
        if(root==null){
            return false;
        }
        path.add(root.data);
        if(root.data==n){
            return true;
        }
        boolean leftCond=getPath(root.left, n, path);
        boolean rightCond=getPath(root.right, n, path);
        if(leftCond||rightCond){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    //lowest common ancestor
    //approach 2
    public static Node lca2(Node root,int n1,int n2){
        if(root==null||root.data==n1 ||root.data==n2){
            return root;
        }
        Node leftLca=lca2(root.left, n1, n2);
        Node rightLca=lca2(root.right, n1, n2);
        if(leftLca==null && rightLca==null){
            return null;
        }
        else if(leftLca==null){
            return rightLca;
        }
        else if(rightLca ==null){
             return leftLca;
        }
        return root;
    }

    //minimum distance between two nodes(n1,n2)
    public static int minDisBT(Node root,int n1,int n2){
        if(root==null){
            return -1;
        }
        Node lca=lca2(root, n1, n2);
        int n1Dis=disFromRoot(lca,n1);
        int n2Dis=disFromRoot(lca,n2);
        return n1Dis+n2Dis;
    }
    public static int disFromRoot(Node root,int n){
        if(root ==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDis=disFromRoot(root.left, n);
        int rightDis=disFromRoot(root.right, n);
        if(leftDis==-1&& rightDis==-1){
            return -1;
        }
        else if(leftDis==-1){
            return ++rightDis;
        }
        else{
            return ++leftDis;
        }
    }

    //find the kth ancestor of the given node
    public static int KthAncestor(Node root,int node,int k){
        if(root==null){
            return -1;
        }
        if(root.data==node){
            return 0;
        }
        int leftDis=KthAncestor(root.left,node,k);
        int rightDis=KthAncestor(root.right,node,k);
        if(leftDis==-1&&rightDis==-1){
            return -1;
        }
        int max=Math.max(leftDis, rightDis);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;        
    }

    //transform the tree into the sum of its subtree
    public static int transform(Node root){
        //return root node
        if(root==null){
            return 0;
        }
        int leftTrf=transform(root.left); 
        int rightTrf=transform(root.right);
        int curValue=root.data;
        int newLeft=root.left==null?0:root.left.data;
        int newright=root.right==null?0:root.right.data;
        root.data=newLeft+leftTrf+newright+rightTrf;
        return curValue;
    }

    //print binary tree in preorder sequence
    public static void printBT(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        printBT(root.left);
        printBT(root.right);
    }

    //Check if a Binary Tree is univalued or not
    public static boolean isUnivalued(Node root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.data!=root.left.data){
            return false;
        }
        if(root.right!=null && root.data!=root.right.data){
            return false;
        }

        boolean leftSubTree=isUnivalued(root.left);
        boolean rightSubTree=isUnivalued(root.right);
        return leftSubTree&&rightSubTree;
    }

    //mirror the binary tree
    public static void mirrorBT(Node root){
        if(root==null){
            return ;
        }
        mirrorBT(root.left);
        mirrorBT(root.right);
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
    }

    //Delete leaf nodes with values as x
    public static Node deleteLeaf(Node root,int x){
        if(root==null){
            return null;
        }
        
        root.left=deleteLeaf(root.left, x);
        root.right=deleteLeaf(root.right, x);
        if(root.data==x&&root.left==null && root.right==null ){
            return null;
        }
        return root;
    }

    //Maximum Path Sum in a Binary Tree
    public static int maxPathSum(Node root){
        if(root==null){
            return 0;
        }
        int leftSubTree=maxPathSum(root.left);
        int rightSubTree=maxPathSum(root.right);
        int withRootSum=leftSubTree+rightSubTree+root.data;
        int max=Math.max(Math.max(leftSubTree, rightSubTree),withRootSum);
        return max;

    }

}
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        int nodes[]={1,2,3,-1,-1,4,-1,-1,5,-1,6,-1,-1};
        Node root=tree.buildTreePre(nodes);
        tree.printKth(root, 2,1);
        System.out.println();
        int lca=tree.lca1(root, 3, 6);
        System.out.println(lca);
        Node lca2=tree.lca2(root, 3, 6);
        System.out.println(lca2.data);
        System.out.println(tree.minDisBT(root,3 ,4));
        System.out.println(tree.KthAncestor(root, 6, 1));
        System.out.println(tree.transform(root));
        tree.printBT(root);
        int nodes2[]={1,1,1,-1,-1,1,-1,-1,1,-1,1,-1,-1};
        tree.idx=-1;
        Node root2=tree.buildTreePre(nodes2);
        System.out.println();
        System.out.println(tree.isUnivalued(root));
        System.out.println(tree.isUnivalued(root2));
        tree.mirrorBT(root);
        tree.printBT(root);
        int nodess[]={1,3,3,-1,-1,2,-1,-1,3,-1,-1};
        tree.idx=-1;
        Node rooot=tree.buildTreePre(nodess);
        System.out.println();
        tree.printBT(rooot);
        tree.deleteLeaf(rooot, 3);
        System.out.println();
        tree.printBT(rooot);
        int noddes[]={4,2,-1,-1,7,-1,-1};
        tree.idx=-1;
        Node rroot=tree.buildTreePre(noddes);
        System.out.println();
        System.out.println(tree.maxPathSum(rroot));


                
    }
    
}
