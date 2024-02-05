package Tree.Binary_Search_Tree;

import java.util.Stack;
import java.util.ArrayList;

//Assumption there are no duplicates
public class BST_01 {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // insert an val in a BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        if (root.data < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // In-Order traversal
    /*-->In-Order traversal of a BST outputs a sorted sequence. */
    public static void inOrderTrl(Node root) {
        if (root == null) {
            return;
        }
        inOrderTrl(root.left);
        System.out.print(root.data + " ");
        inOrderTrl(root.right);
    }
    //PreOrder traversal of a BST
    public static void preOrderTrl(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTrl(root.left);
        preOrderTrl(root.right);
    }

    // Search in a BST ~TC-0(H) or 0(logN)
    public static boolean searchBST(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return searchBST(root.left, key);
        } else {
            return searchBST(root.right, key);
        }
    }

    // Delete a particular node from BST
    public static Node deleteNode(Node root, int val) {        
        if (root.data < val) {
            root.right = deleteNode(root.right, val);
        }
        else if (root.data > val) {
            root.left = deleteNode(root.left, val);
        }
         else {
            // leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // single child node
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;           
            }
            // double child node
            Node Successor = findInorderSuccessor(root.right);
            root.data = Successor.data;
            root.right = deleteNode(root.right, Successor.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //print in range
    public static void printInRange(Node root,int v1,int v2){
        if(root==null){
            return;
        }
        if(root.data>=v1 &&root.data<=v2){
            printInRange(root.left, v1, v2);
            System.out.print(root.data+" ");
        printInRange(root.right, v1, v2);
       }
       else if(root.data>v2){
        printInRange(root.left, v1, v2);
       }
       else{
        printInRange(root.right, v1, v2);
       }

    }
    
    //Root to leaf path
    public static void rootToLeaf(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(list);
        }        
        rootToLeaf(root.left, list);
        rootToLeaf(root.right, list);
        list.remove(list.size()-1);
    }

    //Validate a BST
    public static boolean isBSTvalidated(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isBSTvalidated(root.left,min ,root ) && isBSTvalidated(root.right,root ,max );
    }

    //Mirror a BST
    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }
        Node left=mirrorBST(root.left);
        Node right=mirrorBST(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = { 6, 9, 4, 8, 2, 5, 1, 3, 10, 7 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        System.out.println();
        inOrderTrl(root);
        boolean Search=searchBST(root,75);
        System.out.println(Search);
        System.out.println();
        root = deleteNode(root, 5);
        root = deleteNode(root, 6);
        System.out.println();
        inOrderTrl(root);
        System.out.println();
        printInRange(root, 4, 8);
        System.out.println();
        ArrayList<Integer> list=new ArrayList<>();
        rootToLeaf(root, list);
        System.out.println(isBSTvalidated(root, null, null));
        System.out.println();
        preOrderTrl(root);
        root=mirrorBST(root);
        System.out.println();
        preOrderTrl(root);



    }
}
