package Linkedlist;

//Deque LinkedList
public class linkedList_02 {

    class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static int size;
    public static Node head;
    public static Node tail;

    //reverse Deque linkedlist --~ 0(n)
    public void reverseDLL(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    //print DeQue linkedlist --~ 0(n)
    public void printDLL(){
        if(head==null){
            System.out.println("null");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //add Node inFirst method in deQue linklist --~0(1)
    public void addFirstLLD(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    //add Node inLast method in deQue linklist --~0(1)
    public void addLastLLD(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;
    }

    //remove Node inlast method in deQue linklist --~0(1)
    public int removeLastLLD(){
        if(head==null){
            return -1;
        }
        if(head.next==null){
            int val=head.data;
            size--;
            head=tail=null;
            return val;
        }
        int val=tail.data;
        size--;
        tail=tail.prev;
        tail.next=null;        
        return val;        
    }

    //remove Node infirst method in deQue linklist --~0(1)
    public int removeFirstLLD(){
        if(head==null){
            return -1;
        }
        if(head.next==null){
            size--;
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;

    }    

    public static void main(String[] args) {
        linkedList_02 dLL=new linkedList_02();
        dLL.addFirstLLD(2);
        dLL.addFirstLLD(1);
        dLL.addLastLLD(3);
        dLL.addLastLLD(4);
        dLL.printDLL();
        // dLL.removeFirstLLD();
        // dLL.printDLL();
        // dLL.removeLastLLD();
        // dLL.printDLL();
        dLL.reverseDLL();
        dLL.printDLL();

        
        
    }
}
