package Chap1_Fundamental.Section3_Bag_Queue_Stack;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class _3_8_Linked_List_Stack<Item> implements Iterable<Item> {
    private Node first; // 栈顶指针
    private int N; /////// 元素数量

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node newFirst = new Node(item, first);
        first = newFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
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
        _3_8_Linked_List_Stack<String> stack = new _3_8_Linked_List_Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop() + " ");
            } else {
                stack.push(s);
            }
        }
        
        for (String string : stack) {
            System.out.println(string);
        }
    }
}
