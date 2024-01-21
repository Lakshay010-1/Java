package Stack;
import java.util.ArrayList;

//Stack implemented by Arraylist
public class stack_01 {    
    static class AStack{
        static ArrayList<Integer> Alist=new ArrayList<>();
        //isEmpty operation
        public static boolean isEmpty(){
            return Alist.size()==0;
        }
        //push operation
        public static void push(int data){
            Alist.add(data);
        }
        //pop operation
        public static int pop(){
            int n=Alist.size();
            if(n==0){
                return Integer.MIN_VALUE;
            }
            int top=Alist.get(n-1);
            Alist.remove(n-1);
            return top;
        }
        // peek operation
        public static int peek(){
            int n=Alist.size();
            if(n==0){
                return Integer.MIN_VALUE;
            }
            return Alist.get(n-1);
        }
    }    

    public static void main(String[] args) {
        AStack s=new AStack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("peek="+s.peek());

        //print Alist
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }    
}
