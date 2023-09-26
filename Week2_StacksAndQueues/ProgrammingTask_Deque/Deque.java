package Week2_StacksAndQueues.ProgrammingTask_Deque;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    // define Node class and set two pointers
    private class Node {

        public Node(Item item, Node prev, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        Item item;
        Node next;
        Node prev;
    }

    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null || last == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {

        // corner case detect
        if (item == null) {
            throw new IllegalArgumentException("Input: null is illegal.");
        }

        size++;

        if (isEmpty()) {
            first = new Node(item, null, null);
            last = first;
        } else {
            Node oldfirst = first;
            first = new Node(item, null, oldfirst);
            oldfirst.prev = first;
        }
    }

    // add the item to the back
    public void addLast(Item item) {

        // corner case detect
        if (item == null) {
            throw new IllegalArgumentException();
        }

        size++;

        if (isEmpty()) {
            first = new Node(item, null, null);
            last = first;
        } else {
            last.next = new Node(item, last, null);
            last = last.next;
        }

    }

    // remove and return the item from the front
    public Item removeFirst() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        size--;

        Item buffer = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            // first == null
            // that means deck is empty, we should set last to null too
            last = null;
        }
        return buffer;

    }

    // remove and return the item from the back
    public Item removeLast() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        size--;

        Item buffer = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            // last == null
            // that means deck is empty and we need set first to null too
            first = null;
        }
        return buffer;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {

            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            Item buffer = current.item;
            current = current.next;
            return buffer;
        }

    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> deck = new Deque<Integer>();
        deck.addFirst(1);
        deck.addLast(2);
        deck.addLast(3);
        for (Integer integer : deck) {
            StdOut.print(integer);
        }
        deck.removeFirst();
        deck.removeLast();
        StdOut.print(deck.size());
        for (Integer integer : deck) {
            StdOut.print(integer);
        }
        /*
        int k = 1;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("af")) {
                deck.addFirst(k++);
            } else if (s.equals("al")) {
                deck.addLast(k++);
            } else if (s.equals("rf")) {
                deck.removeFirst();
            } else if (s.equals("rl")) {
                deck.removeLast();
            }

            for (Integer integer : deck) {
                StdOut.print(integer + " ");
            }
            StdOut.print("size = " + deck.size());
            StdOut.println();
        }
        */
    }
}
