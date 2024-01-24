package Queue;

import java.util.Deque;
import java.util.LinkedList;

//Deque
public class queue_04 {

    //Stack using Deque
    static class StackDQ{
        static Deque<Integer> dq=new LinkedList<>();

        //isEmpty operation TC~0(1)
        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //push operation TC~0(1)
        public static void push(int data){
            dq.addLast(data);
        }

        //pop operation TC~0(1)
        public static int pop(){
            if(dq.isEmpty()){
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            return dq.removeLast();
        }

        //peek operation TC~0(1)
        public static int peek(){
            if(dq.isEmpty()){
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            return dq.getLast();
        }
    }

    //Queue using Deque
    static class QueueDQ{
        static Deque<Integer> dq=new LinkedList<>();

        //isEmpty operation TC~0(1)
        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //add operation TC~0(1)
        public static void add(int data){
            dq.addLast(data);
        }

        //remove operation TC~0(1)
        public static int remove(){
            if(dq.isEmpty()){
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            return dq.removeFirst();
        }

        //peek operation TC~0(1)
        public static int peek(){
            if(dq.isEmpty()){
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            return dq.getFirst();
        }

    }
    public static void main(String[] args) {
        System.out.println("deque operations");
        Deque <Integer> dq=new LinkedList<>();
        dq.addFirst(2);
        dq.addFirst(1);
        dq.addLast(3);
        dq.addLast(4);
        dq.add(5);
        dq.removeFirst();
        System.out.println(dq);
        System.out.println();

        System.out.println("Stack using Deque");
        StackDQ sdq=new StackDQ();
        sdq.push(1);
        sdq.push(2);
        sdq.push(3);
        System.out.println("pop = "+sdq.pop());
        sdq.push(4);
        while(!sdq.isEmpty()){
            System.out.print(sdq.pop()+" ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Queue using Deque.");
        QueueDQ qdq=new QueueDQ();
        qdq.add(1);
        qdq.add(2);
        qdq.add(3);
        System.out.println("remove = "+qdq.remove());
        qdq.add(4);
        while(!qdq.isEmpty()){
            System.out.print(qdq.remove()+" ");
        }
        System.out.println();
        
    }
    
}
