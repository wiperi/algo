package Chap1_Fundamental.Section3_Bag_Queue_Stack.Ex;

import java.util.Iterator;

import Chap1_Fundamental.Section3_Bag_Queue_Stack.Node;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.3.29 用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非
 * 空则last.next 的值为first。只能使用一个Node 类型的实例变量（last）。
 */
public class _29_Circle_Linked_List_Queue<Item> implements Iterable<Item> {
    Node<Item> last;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        size++;
        Node<Item> newNode = new Node<Item>(item, null);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            // (last != null)
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public Item dequeue() {
        size--;
        if (size == 0) {
            Item item = last.item;
            last = null;
            return item;
        }
        Item item = last.next.item;
        last.next = last.next.next;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int curSize = size;
            private Node<Item> cur = last.next;

            @Override
            public boolean hasNext() {
                return cur != null && curSize != 0;
            }

            @Override
            public Item next() {
                Item item = cur.item;
                cur = cur.next;
                curSize--;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        _29_Circle_Linked_List_Queue<String> q = new _29_Circle_Linked_List_Queue<>();

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
        for (String string : q) {
            System.out.println(string);
        }
    }
}
