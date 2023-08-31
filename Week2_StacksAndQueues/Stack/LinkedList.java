package Week2_StacksAndQueues.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedList {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isempty() {
        return first == null;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedList stack = new LinkedList();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop() + " ");
            } else {
                stack.push(s);
            }
        }
    }
}