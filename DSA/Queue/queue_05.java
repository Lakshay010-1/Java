package Queue;

import java.util.Queue;
import java.util.LinkedList;

//Stack using 2 Queues.
public class queue_05 {

    //Approach 1    
    /*
     * add --~ TC=0(n)
     * remove --~ TC=0(1)
     * peek --~ TC=0(1)
     */
    static class StackQ1{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();

        // isEmpty operation TC --~ 0(1)
        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        //push operation TC --~ 0(n)
        public static void push(int data){
            //emptying q1 queue
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            //adding data to the q1 queue
            q1.add(data);
            //emptying q2 queue
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        //pop operation TC --~ 0(1)
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return q1.remove();
        }

        //peek operation TC --~ 0(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return q1.peek();
        }
    }

    //Approach 2
    /*
     * add --~ TC=0(1)
     * remove --~ TC=0(n)
     * peek --~ TC=0(n)
     */
    static class StackQ2{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();

        // isEmpty operation TC --~ 0(1)
        public static boolean isEmpty(){
            return q1.isEmpty();
        }

        //push operation TC --~ 0(1)
        public static void push(int data){
            q1.add(data);
        }

        //pop operation TC --~ 0(n)
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            while(q1.size()!=1){
                q2.add(q1.remove());
            }
            int top=q1.remove();
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
            return top;
        }

        //peek operation TC --~ 0(n)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            while(q1.size()!=1){
                q2.add(q1.remove());
            }
            int top=q1.peek();
            q2.add(q1.remove());
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
            return top;
        }

    }

    public static void main(String[] args) {

        /*
        StackQ1 sq1=new StackQ1();
        sq1.push(1);
        sq1.push(2);
        sq1.push(3);
        System.out.println("pop = "+sq1.pop());
        sq1.push(4);
        System.out.println("peek = "+sq1.peek());
        while(!sq1.isEmpty()){
            System.out.println(sq1.pop());
        } 
         */

         /*
         System.out.println();
        System.out.println();
        StackQ2 sq2=new StackQ2();
        sq2.push(1);
        sq2.push(2);
        sq2.push(3);
        System.out.println("pop = "+sq2.pop());
        sq2.push(4);
        System.out.println("peek = "+sq2.peek());
        while(!sq2.isEmpty()){
            System.out.println(sq2.pop());
        }          
          */

        
        
    }
    
}
