package Stack;
import java.util.Stack;

public class stack_03 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    // push to bottom in the stack
    public static void pushToBottom(Stack<Integer> s, int data) {
        if (s.size() == 0) {
            s.push(data);
            return;
        }
        int currValue = s.pop();
        pushToBottom(s, data);
        s.push(currValue);
    }

    // print stack
    public static void printStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        System.out.println(top);
        printStack(s);
        s.push(top);
    }

    // reverse a string using stack
    public static String reverseString(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }
        Stack<Character> s = new Stack<>();
        for (char currChar : str.toCharArray()) {
            s.push(currChar);
        }
        StringBuilder strb = new StringBuilder("");
        while (!s.isEmpty()) {
            strb.append(s.pop());
        }
        return strb.toString();
    }

    // reverse a stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushToBottom(s, top);
    }

    // stack span
    public static void stockSpan(int stocks[], int span[]) {
        if (stocks.length == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            while (!s.isEmpty() && stocks[i] >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // next greater/smaller element
    // next greater element (right)
    public static void grElementRight(int arr[], int grElement[]) {
        if (arr.length == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                grElement[i] = -1;
            } else {
                grElement[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // next greater element (left)
    public static void grElementLeft(int arr[], int grElement[]) {
        if (arr.length == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                grElement[i] = -1;
            } else {
                grElement[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // next smaller element (right)
    public static void smElementRight(int height[], int smElement[]) {
        int n = height.length;
        if (n == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                smElement[i] = n;
            } else {
                smElement[i] = height[s.peek()];
            }
            s.push(i);
        }
    }

    // next smaller element (left)
    public static void smElementLeft(int height[], int smElement[]) {
        if (height.length == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[i] <= height[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                smElement[i] = -1;
            } else {
                smElement[i] = height[s.peek()];
            }
            s.push(i);
        }
    }

    // valid parentheses
    public static boolean isValidParantheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar == ')' || currChar == ']' || currChar == '}') {
                if (s.isEmpty()) {
                    return false;
                }
                if ((currChar == ')' && s.peek() == '(') || (currChar == '}' && s.peek() == '{')
                        || (currChar == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                s.push(currChar);
            }
        }
        if (!s.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    // duplicate parentheses
    // assumption that it contains valid parantheses
    public static boolean isDuplicateParantheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);

            if (currChar == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(currChar);
            }
        }
        return false;
    }

    // maximum rectangular histogram area;
    public static int maxAreaHistogram(int height[], int width) {
        int maxArea = 0;
        int smEltRight[] = new int[height.length];
        int smEltLeft[] = new int[height.length];
        smElementLeft(height, smEltLeft);
        smElementRight(height, smEltRight);

        for (int i = 0; i < height.length; i++) {
            int currArea = height[i] * ((smEltRight[i] - smEltLeft[i] - 1) * width);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    // palindrome { given linked list}
    public static boolean isPalindromic(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> s = new Stack<>();
        Node temp = head;
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        boolean isPalindromic = true;
        while (temp != null) {
            int i = s.pop();
            if (temp.data == i) {
                isPalindromic = true;
            } else {
                isPalindromic = false;
                break;
            }
            temp = temp.next;
        }
        return isPalindromic;
    }

    // trap rain water
    public static int trappedRainWater(int rainGraph[], int width) {
        int n = rainGraph.length;
        if (n < 3) {
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && rainGraph[s.peek()] < rainGraph[i]) {
                int pop_height = rainGraph[s.pop()];
                if (s.isEmpty()){
                    break;
                    }
                int distance = i - s.peek() - 1;
                int min_height = Math.min(rainGraph[s.peek()],rainGraph[i])- pop_height;
                ans += distance * min_height;
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        printStack(s);
        System.out.println();

        /* 
        int rainGraph[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 6 };
        int trappedRainWater = trappedRainWater(rainGraph, 1);
        System.out.println(trappedRainWater);
        */

        /*
         * Node one = new Node(1);
         * Node two = new Node(1);
         * Node three = new Node(3);
         * Node four = new Node(4);
         * Node five = new Node(3);
         * Node six = new Node(2);
         * Node seven = new Node(1);
         * one.next = two;
         * two.next = three;
         * three.next = four;
         * four.next = five;
         * five.next = six;
         * six.next = seven;
         * boolean condition = isPalindromic(one);
         * System.out.println("Palindrome :" + condition);
         */

        /*
         * int height[]={2,1,5,6,2,3};
         * int maxArea=maxAreaHistogram(height, 1);
         * System.out.println(maxArea);
         */

        /*
         * String dpth1="((a+b))";
         * String dpth2="(a+b)";
         * System.out.println(isDuplicateParantheses(dpth1));
         * System.out.println(isDuplicateParantheses(dpth2));
         */

        /*
         * String vpth1="(){}[]()";
         * String vpth2="({]})[]";
         * System.out.println(isValidParantheses(vpth1));
         * System.out.println(isValidParantheses(vpth2));
         */

        /*
         * int arr[]={6,8,0,1,3};
         * int grElement[]=new int[arr.length];
         * grElementRight(arr, grElement);
         * printArray(grElement);
         */

        /*
         * int stocks[]={100,80,60,70,60,85,100};
         * int span[]=new int[stocks.length];
         * stockSpan(stocks,span);
         * printArray(span);
         */

        /*
         * reverseStack(s);
         * printStack(s);
         */

        /*
         * String str="a1b2c3";
         * System.out.println(reverseString(str));
         */
    }
}
