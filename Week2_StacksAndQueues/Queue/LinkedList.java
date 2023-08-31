package Week2_StacksAndQueues.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedList {

    private class Node {
        String item;
        Node next;
    }

    private Node first;
    private Node last;

    public void enqueue(String item) {
        if (isempty()) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            last.next = new Node();
            last.next.item = item;
            last = last.next;
        }
    }

    public String dequeue() {
        if (isempty()) {
            return null;
        }
        String buffer = first.item;
        first = first.next;
        return buffer;
    }

    public boolean isempty() {
        return first == null;
    }

    public void print() {
        Node cur = first;
        while (cur != null) {
            StdOut.print(cur.item + " ");
            cur = cur.next;
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        LinkedList queque = new LinkedList();
        queque.print();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                queque.dequeue();
                queque.print();
            } else {
                queque.enqueue(item);
                queque.print();
            }
        }
    }
}