package Stack;

//Stack implemented by LinkedList 
public class stack_02 {   

    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data=data;
            this.next=null;
        }
    }

    static class LLStack{

        static Node head=null;
        static int size;

        //isEmpty operation
        public static boolean isEmpty(){
            return head==null;
        }
        //push operation
        public static void push(int data){
            Node newNode =new Node(data);
            size++;
            if(isEmpty() ){
                head=newNode;
                return ;
            }
            newNode.next=head;
            head=newNode;
        }
        //pop operation
        public static int pop(){
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        //peek operation
        public static int peek(){
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            return head.data;
       }

    }
        
    public static void main(String[] args) {
        LLStack s=new LLStack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }    
}
