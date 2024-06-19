package Queue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class queue_06 {

    // first non-repeating letter in a stream of characters
    // Assumption string only contains smallcase english characters only
    public static void nonRptChar(String str) {
        if (str.length() == 0) {
            return;
        }
        int fre[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            fre[currChar - 'a']++;
            q.add(currChar);
            while (!q.isEmpty() && fre[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    // interleave 2 halves of a queue (even length)
    public static void interLeaveQueue(Queue<Integer> q1) {
        if (q1.size() == 0) {
            System.out.println("Queue is Empty.");
            return;
        }
        Queue<Integer> q2 = new LinkedList<>();
        int q2Size = q1.size() / 2;
        int i = 0;
        while (i < q2Size) {
            q2.add(q1.remove());
            i++;
        }
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }

    // reverse a Queue
    public static void reverseQueue(Queue<Integer> q) {
        if (q.size() == 0 || q.size() == 1) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // Given a number N. The task is to generate and print all binary numbers with
    // decimal values from 1 to N.
    static void PrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");
        while (n > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
            n--;
        }
    }

    //Reversing the first K elements of a Queue
    public static void reverseKth(Queue<Integer> q,int k){
        if(q.size()==0 || k>q.size()){
            return;
        }        
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        int i=0;
        while(i<k){
            q1.add(q.remove());
            i++;
        }
        while(!q.isEmpty()){
            q2.add(q.remove());
        }
        reverseQueue(q1);
        while(!q1.isEmpty()){
            q.add(q1.remove());
        }
        while(!q2.isEmpty()){
            q.add(q2.remove());
        }
    }

    

    public static void main(String[] args) {
        // String str = "aabccxb";
        // nonRptChar(str);
        // System.out.println();
        // Queue<Integer> q1 = new LinkedList<>();
        // q1.add(1);
        // q1.add(2);
        // q1.add(3);
        // q1.add(4);
        // q1.add(5);
        // q1.add(6);
        // q1.add(7);
        // q1.add(8);
        // q1.add(9);
        // q1.add(10);
        // interLeaveQueue(q1);
        // while (!q1.isEmpty()) {
        //     System.out.print(q1.remove() + " ");
        // }
        // System.out.println();
        // Queue<Integer> q2 = new LinkedList<>();
        // q2.add(1);
        // q2.add(2);
        // q2.add(3);
        // q2.add(4);
        // q2.add(5);
        // q2.add(6);
        // q2.add(7);
        // q2.add(8);
        // q2.add(9);
        // q2.add(10);
        // reverseQueue(q2);
        // while (!q2.isEmpty()) {
        //     System.out.print(q2.remove() + " ");
        // }
        // System.out.println();
        // PrintBinary(5);

        // System.out.println();
        // Queue<Integer> q3 = new LinkedList<>();
        // q3.add(1);
        // q3.add(2);
        // q3.add(3);
        // q3.add(4);
        // q3.add(5);
        // q3.add(6);
        // q3.add(7);
        // q3.add(8);
        // q3.add(9);
        // q3.add(10);
        // reverseKth(q3, 5);
        // while (!q3.isEmpty()) {
        //     System.out.print(q3.remove() + " ");
        // }
    }
}
