package Linkedlist;

//SingleQue LinkedList

import java.sql.Time;

public class linkedList_01 {
    public static class Node {
        int data;
        Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // given two intersected linkedlist-es ,to find the intersection Node in the
    // system.
    // Time Complexity : o(m*n) ; Space Complexity: o(1)
    public Node intersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    // Delete N Nodes After M Nodes in a Linked List
    // Time Complexity : o(n) ; Space Complexity: o(1)
    public void skipMdeleteN(Node head, int m, int n) {
        Node curr = head, temp;
        int count;
        while (curr != null) {
            for (count = 1; count < m && curr != null; count++) {
                curr = curr.next;
                if (curr == null) {
                    return;
                }
            }
            temp = curr.next;
            for (count = 1; count <= n && temp != null; count++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("\n");
    }

    // Swapping Nodes in a Linked List
    // Time Complexity : o(n) ; Space Complexity: o(1)
    public void swapXWithY(int x, int y) {
        if (x == y) {
            return;
        }
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null) {
            return;
        }
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }
        if (prevY != null) {
            prevY.next = currX;
        } else
            head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    // place Even data first then odd second in the given Linked List
    // Time Complexity : o(n) ; Space Complexity: o(1)
    public void sortEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;
        while (end.next != null)
            end = end.next;
        Node new_end = end;
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else
            prev = curr;
        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }

    }

    // Merge k Sorted LinkedList
    // Time Complexity : o(n*logk) ; Space Complexity: o(n)

    public Node mergeKlists(Node arr[], int last) {
        while (last != 0) {
            int i = 0, j = last;
            while (i < j) {
                arr[i] = SortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return arr[0];
    }

    public static Node SortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        } else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }

    // zig-zag linkedlist
    public void zigzagLL() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;

        Node curr = midNode.next;
        midNode.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    // merge sort on a linkedlist
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // mid point (mid point should be the end of the left part)
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;
        Node rightHead = midNode.next;
        midNode.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);
    }

    private Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    // remove cycle form the list
    public static void removeCycle() {
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (isCycle == false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
    }

    // check cycle in the linklist
    public static boolean isCycle() {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    // chech if the linklist is palindrome-ic or not
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // find the mid Node
        Node midNode = findMid(head);

        // reverse the 2nd(right) part(right from the mid node)
        Node prev = null;
        Node curr = midNode;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;// right part head
        Node left = head;

        // check if left and right part are equal or not
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // find the mid node of the linklist --~ 0(n)
    public Node findMid(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // delete nth Node from end in linklist --~ 0(n)
    public void deleteNthNodeFromEnd(int Nidx) {
        if (Nidx == size) {
            head = head.next;
            return;
        }

        int i = 1;
        // if nth node from end is at nth index,then from start then it is (size-nth
        // index+1).
        int iTofind = size - Nidx;
        Node prev = head;
        while (i < iTofind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // size of the linklist --~ 0(n)
    public int size() {
        Node temp = head;
        int sz = 0;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        return sz;
    }

    // reverse the linklist method --~ 0(n)
    public void reverse() {
        if (head == null) {
            return;
        }
        Node prev = null;
        Node curr = tail = head;
        Node nextt;
        while (curr != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;

        }
        head = prev;

    }

    // seacrch data in linklist (using recursion) --~ 0(n)
    public int searchREC(Node head, int data) {
        if (head == null) {
            return -1;
        }
        if (head.data == data) {
            return 0;
        }
        int idx = searchREC(head.next, data);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    // search data in linklist (using iteration)--~ 0(n)
    public int searchITR(int data) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == data) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    // remove Node from last method in linklist --~ 0(n)
    public int removeLast() {
        if (size == 0) {
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // remove Node form first method in linklist --~ 0(1).
    public int removeFirst() {
        if (size == 0) { // this condition is equal to (head == null)
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head.next = head;
        size--;
        return val;
    }

    // add Node in given index method in linklist --~0(n)
    public void add(int data, int idx) {
        if (head == null || idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // add Node in first method in linklist --~0(1)
    public void addFirst(int data) {
        // create a new node
        Node newNode = new Node(data);
        size++;
        // check condition
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // linking head to the newNode
        newNode.next = head;
        // making newNode the head
        head = newNode;

    }

    // add Node inlast method in linklist --~0(1)
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // print Linklist --~0(n)
    public void printLL() {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
         * //cycle linkedlist
         * head=new Node(1);
         * Node temp=head.next=new Node(2);
         * head.next.next=new Node(3);
         * head.next.next.next=temp;
         * System.out.println(isCycle());
         * removeCycle();
         * System.out.println(isCycle());
         */

        /*
         * linkedList_01 ll=new linkedList_01();
         * //ll.head=new Node(2);
         * ll.printLL();
         * ll.addFirst(4);
         * ll.printLL();
         * ll.addFirst(5);
         * ll.printLL();
         * ll.addLast(2);
         * ll.printLL();
         * ll.addLast(1);
         * ll.printLL();
         * ll.add(3, 2);
         * ll.printLL();
         * ll.zigzagLL();
         * ll.printLL();
         * System.out.println("size ==> "+ size);
         * System.out.println(ll.searchITR(2));
         * System.out.println(ll.searchREC(head, 10));
         * System.out.println(ll.checkPalindrome());
         */

        /*
         * // intersected linkedlist
         * linkedList_01 ll = new linkedList_01();
         * Node head1 = new Node(10), head2 = new Node(3);
         * Node newNode = new Node(6);
         * head2.next = newNode;
         * newNode = new Node(9);
         * head2.next.next = newNode;
         * newNode = new Node(15);
         * head1.next = newNode;
         * head2.next.next.next = newNode;
         * newNode = new Node(30);
         * head1.next.next = newNode;
         * head1.next.next.next = null;
         * 
         * Node intersectionPoint = ll.intersectionNode(head1, head2);
         * if (intersectionPoint == null) {
         * System.out.print(" No Intersection Point \n");
         * } else {
         * System.out.print("Intersection Point: " + intersectionPoint.data);
         * 
         * }
         */

        /*
         * linkedList_01 ll = new linkedList_01();
         * Node head = null;
         * int m = 1, n = 2;
         * head = push(head, 10);
         * head = push(head, 9);
         * head = push(head, 8);
         * head = push(head, 7);
         * head = push(head, 6);
         * head = push(head, 5);
         * head = push(head, 4);
         * head = push(head, 3);
         * head = push(head, 2);
         * head = push(head, 1);
         * System.out.printf("M = %d, N = %d \n" +
         * "Linked list we have is :\n", m, n);
         * printList(head);
         * ll.skipMdeleteN(head, m, n);
         * System.out.printf("\nLinked list on deletion is :\n");
         * printList(head);
         */

        /*
         * linkedList_01 ll = new linkedList_01();
         * ll.push(7);
         * ll.push(6);
         * ll.push(5);
         * ll.push(4);
         * ll.push(3);
         * ll.push(2);
         * ll.push(1);
         * System.out.print(
         * "\n Linked list before \n");
         * ll.printLL();
         * ll.swapXWithY(4, 3);
         * System.out.print(
         * "\n Linked list after \n");
         * ll.printLL();
         */

        /*
         * linkedList_01 ll = new linkedList_01();
         * ll.push(11);
         * ll.push(10);
         * ll.push(8);
         * ll.push(6);
         * ll.push(3);
         * ll.push(2);
         * ll.push(0);
         * System.out.println("Linked List");
         * ll.printLL();
         * ll.sortEvenOdd();
         * System.out.println("updated Linked List");
         * ll.printLL();
         */

         linkedList_01 ll = new linkedList_01();
        int k = 3;
        int n = 4;
        Node arr[] = new Node[k];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        Node head = ll.mergeKlists(arr, k - 1);
        printList(head);

    }

}
