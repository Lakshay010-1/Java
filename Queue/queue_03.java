package Queue;
import java.util.Stack;

 // Queue using 2 stacks.
public class queue_03 {
   
    // Approach 1
    /*
     * add --~ TC=0(n)
     * remove --~ TC=0(1)
     * peek --~ TC=0(1)
     */
    static class QueueS1 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // isEmpty operation TC --~ 0(1)
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add operation TC --~ 0(n)
        public static void add(int data) {
            // emptying s1 stack
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // pushing data in s1 stack
            s1.push(data);
            // emptying s2 stack
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove operation TC --~ 0(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            return s1.pop();
        }

        // peek operation TC --~ 0(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }
    }

    // Approach 2
    /*
     * add --~ TC=0(1)
     * remove --~ TC=0(n)
     * peek --~ TC=0(n)
     */
    static class QueueS2 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // isEmpty operation TC--~0(1)
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add operation TC--~0(1)
        public static void add(int data) {
            s1.push(data);
        }

        // remove operation TC--~0(n)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            // emptying s1 stack
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // pop-ing the top element of s2 stack
            int top = s2.pop();
            // emptying s2 stack
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return top;
        }

        // peek operation TC--~0(n)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            // emptying s1 stack
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // pop-ing the top element of s2 stack
            int top = s2.peek();
            // emptying s2 stack
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return top;
        }

    }

    public static void main(String[] args) {
        /*
         * QueueS1 qs1=new QueueS1();
         * qs1.add(1);
         * qs1.add(2);
         * qs1.add(3);
         * qs1.remove();
         * qs1.add(4);
         * while(!qs1.isEmpty()){
         * System.out.println(qs1.peek());
         * qs1.remove();
         * }
         */

        /*
         * QueueS2 qs2 = new QueueS2();
         * qs2.add(1);
         * qs2.add(2);
         * qs2.add(3);
         * System.out.println("remove = "+qs2.remove());
         * qs2.add(4);
         * while (!qs2.isEmpty()) {
         * System.out.println(qs2.peek());
         * qs2.remove();
         * }
         */

    }
}
