package Chap1_Fundamental.Section3_Bag_Queue_Stack;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class _3_10_Linked_List_Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node newNode = new Node(item, null);
        if (isEmpty()) {
            last = newNode;
            first = last;
        } else {
            last.next = newNode;
            last = last.next;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;
        if (first == null) {
            last = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                Item item = cur.item;
                cur = cur.next;
                return item;
            }

        };
    }

    public static void main(String[] args) {
        _3_10_Linked_List_Queue<String> q = new _3_10_Linked_List_Queue<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("-")) {
                q.dequeue();
                for (String string : q) {
                    System.out.println("q: " + string);
                }
            } else {
                q.enqueue(s);
                for (String string : q) {
                    System.out.println("q: " + string);
                }
            }
        }
    }
}
