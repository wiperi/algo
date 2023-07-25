package Week2_StackssAndQueques;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class StackOfGenericOnLinkedList<Type> {
    private class Node {
        Type item;
        Node next;
    }

    private Node first = null;

    public boolean isempty() {
        return first == null;
    }

    public void push(Type item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Type pop() {
        Type item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {

        StackOfGenericOnLinkedList<Integer> arr = new StackOfGenericOnLinkedList<Integer>();
        arr.print();

        while (!StdIn.isEmpty()) {
            int item = StdIn.readInt();
            if (item == -1) {
                arr.pop();
                arr.print();
            } else {
                arr.push(item);
                arr.print();
            }
        }
    }

    public void print() {
        Node cur = first;
        while (cur != null) {
            StdOut.print(cur.item + " ");
            cur = cur.next;
        }
        StdOut.println();
    }
}
