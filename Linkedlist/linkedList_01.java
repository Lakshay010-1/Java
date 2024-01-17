package Linkedlist;
public class linkedList_01 {
    public static class Node{
        int data;
        Node next;

       public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; 
    
    //chech if the linklist is palindrome-ic or not
    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        
        //find the mid Node
        Node midNode=findMid(head);

        //reverse the 2nd(right) part(right from the mid node)
        Node prev=null;
        Node curr=midNode;        
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;//right part head 
        Node left=head;

        //check if left and right part are equal or not
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
         return true;        
    }

    //find the mid node of the linklist --~ 0(n)
    public Node findMid(Node head){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //delete nth Node from end in linklist --~ 0(n)
    public void deleteNthFromEnd(int Nidx){
        if(Nidx==size){
            head=head.next;
            return ;
        }
        
        int i=1;
        //if nth node from end is at nth index,then from start then it is (size-nth index+1).
        int iTofind=size-Nidx;
        Node prev=head;
        while(i<iTofind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;        
    }

    //size of the linklist --~ 0(n)
    public int size(){
        Node temp=head;
        int sz=0;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        return sz;
    }
    
    //reverse the linklist method --~ 0(n)
    public void reverse(){
        if(head==null){
            return ;
        }   
        Node prev=null;
        Node curr=tail=head;
        Node nextt;
        while(curr!=null){
            nextt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextt;
            
        }
        head=prev;


    }

    //seacrch data in linklist (using recursion) --~ 0()
    public int searchREC(Node head,int data){
        if(head==null){
            return -1;
        }
        if(head.data==data){
            return 0;
        }
        int idx=searchREC(head.next, data);
        if(idx==-1){
            return -1;
        }
        
        return idx+1;
    }

     //search data in linklist (using iteration)--~ 0(n)
     public int searchITR(int data){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==data){
                return i;
            }
            i++;
            temp=temp.next;
        }
        return -1;
     }

    //remove Node from last method in linklist --~ 0(n)
    public int removeLast(){
        if(size==0){
            return -1;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    
    //remove Node form first method in linklist --~ 0(1).
    public int removeFirst(){
        if(size==0){ //this condition is equal to (head == null)
            return -1;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head.next=head;
        size--;
        return val;
    }

    //add Node in given index method in linklist --~0(n)
    public void add(int data,int idx){
        if(head==null || idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
       
    }

    //add Node in first method in linklist --~0(1)
    public void addFirst(int data){
        //create a new node
        Node newNode=new Node(data);
        size++;
        //check condition
        if(head==null){
            head=tail=newNode;
            return;
        }
        //linking head to the newNode
        newNode.next=head;
        //making newNode the head
        head=newNode;

    }

    //add Node inlast method in linklist --~0(1)
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        tail=newNode;
    }

    //print Linklist --~0(n)
    public void printLL(){
        if(head==null){
            System.out.println("null");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {  
        linkedList_01 ll=new linkedList_01();
        //ll.head=new Node(2);   
        ll.printLL();  
        ll.addFirst(2);
        ll.printLL();
        ll.addFirst(1);
        ll.printLL();
        //ll.addLast(2);
        ll.printLL();
        ll.addLast(3);
        ll.printLL();
        //ll.add(3, 2);
        ll.printLL();
        System.out.println("size ==> "+ size);
    
        System.out.println(ll.searchITR(2));
        System.out.println(ll.searchREC(head, 10));
        System.out.println(ll.checkPalindrome());
    }
}
