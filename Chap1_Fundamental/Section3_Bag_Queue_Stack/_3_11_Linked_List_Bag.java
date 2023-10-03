package Chap1_Fundamental.Section3_Bag_Queue_Stack;

import java.util.Iterator;

public class _3_11_Linked_List_Bag<Item> implements Iterable<Item> {
    private Node first; // 链表的首结点

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void add(Item item) { // 和Stack 的push() 方法完全相同
        Node oldfirst = first;
        first = new Node(item, oldfirst);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
