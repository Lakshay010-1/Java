package Queue;

//Queue using a LinkedList
public class queue_02 {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class QueueLL{
        static Node head=null;
        static Node tail=null;

        //isEmpty operation TC--~0(1)
        public static boolean isEmpty(){
            return head==null && tail==null;
        }

        //add operation TC--~0(1)
        public static void add(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        //remove operation TC--~0(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            int top=head.data;
            if(head==tail){
                head=tail=null;
                return top;
            }
            head=head.next;
            return top;
        }

        //peek operation TC--~0(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

        //print Queue LinkedList TC--~0(n)
        public static void printQL(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        QueueLL ql=new QueueLL();
        ql.add(1);
        ql.add(2);
        ql.add(3);
        ql.printQL();
        System.out.println("remove ="+ql.remove());
        ql.add(4);
        System.out.println("peek ="+ql.peek());
        /* 
         while(!ql.isEmpty()){
            System.out.println(ql.remove());
         }
        */
        ql.printQL();     
    }
}
