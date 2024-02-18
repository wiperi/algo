package List.Queue;

import org.junit.jupiter.api.Assertions;

/**
 * Dequeue also known as double-ended queue. The elements can be added or
 * removed from either the front (head) or the back (tail).
 * 
 * <p>
 * Methods List: <p>
 * isEmpty() - is the deque empty? <p>
 * size() - return the number of items on the deque <p>
 * addFirst(Item item) - add the item to the front <p>
 * addLast(Item item) - add the item to the back <p>
 * removeFirst() - remove and return the item from the front <p>
 * removeLast() - remove and return the item from the back <p>
 */
public class Dequeue {

    /**
     * Inner class Node
     */
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

    // instance variables
    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Dequeue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 
     * @return is the deque empty?
     */
    public boolean isEmpty() { return first == null || last == null; }

    /**
     * 
     * @return the number of items on the deque
     */
    public int size() {
        return size;
    }

    public void addFirst(int val) {
        size++;
        if (isEmpty()) {
            first = new Node(val, null, null);
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node(val, null, oldFirst);
            oldFirst.prev = first;
        }
    }

    public void addLast(int val) {
        size++;
        if (isEmpty()) {
            last = new Node(val, null, null);
            first = last;
        } else {
            Node oldLast = last;
            last = new Node(val, oldLast, null);
            oldLast.next = last;
        }
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The dequeue is empty.");
        }
        size--;
        int val = first.val;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        return val;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The dequeue is empty.");
        }
        size--;
        int val = last.val;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        return val;
    }

    // unit testing
    public static void main(String[] args) {        
        Dequeue dequeue = new Dequeue();

        // dequeue: 1 -> 2 -> 3 -> 4
        dequeue.addFirst(2);
        dequeue.addFirst(1);
        dequeue.addLast(3);
        dequeue.addLast(4);
        
        Assertions.assertEquals(1, dequeue.removeFirst());
        Assertions.assertEquals(4, dequeue.removeLast());
        Assertions.assertEquals(2, dequeue.removeFirst());
        Assertions.assertEquals(3, dequeue.removeLast());
        System.out.println("All test cases passed!");
    }
}
