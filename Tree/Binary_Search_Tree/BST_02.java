package Tree.Binary_Search_Tree;

import java.util.ArrayList;

public class BST_02 {
    static class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info{
        boolean isBST;
        int size,min,max;
        Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
            this.size=size;
        }
    }

    //preOrder Traversal
    public static void preOrderTra(Node root1){
        if(root1==null){
            return ;
        }
        System.out.print(root1.data+" ");
        preOrderTra(root1.left);
        preOrderTra(root1.right);
    }
    
    // Construct a Balanced BST
    public static Node balanceBST(ArrayList<Integer> nodes, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(nodes.get(mid));
        root.left=balanceBST(nodes, st, mid - 1);
        root.right=balanceBST(nodes, mid + 1, end);
        return root;
    }
    // Convert a normal BSt into Balanced BST
    public static Node balanceNormalBST(Node root) {    
        if (root == null) {
            return null;
        }
        // Inorder sequence
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);
        //build bst
        root = balanceBST(list, 0, list.size() - 1);
        return root;    
    }
    public static void getInorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }
    // Merge 2 BST into a Balanced BST
    public static Node merge2BST(Node root1, Node root2) {
        ArrayList<Integer> result = new ArrayList<>();
        merge(root1, root2, result);
        return balanceBST(result, 0, result.size()-1);
    }
    public static void merge(Node root1, Node root2, ArrayList<Integer> result) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        int p1 = 0, p2 = 0;
        while (p1 < arr1.size() && p2 < arr2.size()) {
            if (arr1.get(p1) <= arr2.get(p2)) {
                result.add(arr1.get(p1));
                p1++;
            } else {
                result.add(arr2.get(p2));
                p2++;
            }
        }
        while (p1 < arr1.size()) {
            result.add(arr1.get(p1));
            p1++;
        }
        while (p2 < arr2.size()) {
            result.add(arr2.get(p2));
            p2++;
        }
    }

    // Size/Total Nodes of largest BST in Binary Tree
    public static int maxSize=0;
    public static Info sizeBiggestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftTree=sizeBiggestBST(root.left);
        Info rightTree=sizeBiggestBST(root.right);
        int size=leftTree.size+rightTree.size+1;
        int min=Math.min(root.data,Math.min(leftTree.min,rightTree.min));
        int max=Math.max(root.data,Math.max(leftTree.max,rightTree.max));

        if(root.data <= leftTree.max || root.data >= rightTree.min){
            return new Info(false, size, min, max);
        }
        if(leftTree.isBST && rightTree.isBST){
            maxSize=Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        /*
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(8);
        list1.add(10);
        list1.add(11);
        list1.add(12);
        Node root1=balanceBST(list1, 0, list1.size()-1);
        preOrderTra(root1);
        System.out.println();
         */

        /* 
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(8);
        list2.add(6);
        list2.add(5);
        list2.add(3);
        list2.add(10);
        list2.add(11);
        list2.add(12);
        Node root2 = new Node(8);
        root2.left=new Node(6);
        root2.left.left=new Node(5);
        root2.left.left.left=new Node(3);
        root2.right=new Node(10);
        root2.right.right=new Node(11);
        root2.right.right.right=new Node(12);
         root2=balanceNormalBST(root2);      
        preOrderTra(root2);
         */

         /*
         Node root3 = new Node(50);
        root3.left=new Node(30);
        root3.left.left=new Node(5);
        root3.left.right=new Node(20);
        root3.right=new Node(60);
        root3.right.left=new Node(45);
        root3.right.right=new Node(70);
        root3.right.right.left=new Node(65);
        root3.right.right.right=new Node(80);
        Info info=sizeBiggestBST(root3);
        System.out.println("size "+maxSize);
          */

          /* 
          Node root4=new Node(2);
          root4.left=new Node(1);
          root4.right=new Node(4);

          Node root5=new Node(9);
          root5.left=new Node(3);
          root5.right=new Node(12);

          Node root6=merge2BST(root4, root5);
          preOrderTra(root6);
          */
    }
}
