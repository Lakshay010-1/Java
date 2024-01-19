package Linkedlist;

//circular linkedlist
//[circular linkedlist is both SingleQue circular linkedlist and Deque circular linkedlist ]
public class linkedList_03 {
    static class Node {
        int data;
        Node next;
    }

    //add Node in a empty circular linkedlist
     static Node addToEmptyLL(Node last, int data) {
        if (last != null) {
            return last;
        }
        Node newNode = new Node();
        newNode.data = data;
        last = newNode;
        newNode.next = last;
        return last;
    }
    
    //add Node at first(head) in an circular linkedlist
    static Node addFirst(Node last, int data) {
        if (last == null) {
            return addToEmptyLL(last, data);
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    //add Node at last in a  circular linkedlist
    static Node addLast(Node last, int data) {
        if (last == null) {
            return addToEmptyLL(last, data);
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    //add Node after an particular item in a circular linkedlist
    static Node addAfterItem(Node last, int data, int item) {
        if (last == null) {
            return null;
        }
        Node newNode;
        Node temp = last.next;

        do {
            if (temp.data == item) {
                newNode = new Node();
                newNode.data = data;
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == last){
                    last = newNode;
                    return last;
            }
            }
            temp = temp.next;
        } while (temp != last.next);

        System.out.println(item + "The given node is not present in the list");
        return last;
    }

    //deleter Node in a circular linkedlist
    static Node deleteNode(Node last, int key) {
        if (last == null){
            return null;
        }
        if (last.data == key && last.next == last) {
            last = null;
            return last;
        }
        Node temp = last;
        if (temp.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next.data == key) {
            temp.next = temp.next.next;
        }
        return last;
    }

    // print the circular linkedlist
    static void printCLL(Node last) {
        if (last == null) {
            System.out.println("null");
            return;
        }
        Node temp = last.next;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);

        System.out.println();
    }

    public static void main(String[] args) {
        Node last = null;
        last = addToEmptyLL(last, 6);
        last = addLast(last, 8);
        last = addFirst(last, 2);
        last = addAfterItem(last, 10, 2);
        printCLL(last);
        deleteNode(last, 8);
        printCLL(last);
    }
}