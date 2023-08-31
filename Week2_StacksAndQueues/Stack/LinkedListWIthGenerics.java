package Week2_StacksAndQueues.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class LinkedListWIthGenerics<T> implements Iterable<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node first = null;

    public boolean isempty() {
        return first == null;
    }

    public void push(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    /**************************** 实现迭代器 **********************************/
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    // 为了实现Iterable接口，需要先实现Iterator接口
    private class StackIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    /*************************************************************************/

    public static void main(String[] args) {

        /************************* 迭代器测试 *********************************/
        LinkedListWIthGenerics<String> stack = new LinkedListWIthGenerics<>();

        stack.push("3 ");
        stack.push("3 ");
        stack.push("2 ");

        // foreach语句的效果和下面的while相同但是更精简
        for (String s : stack) {
            StdOut.print(s);
        }

        Iterator<String> stackI = stack.iterator();
        while (stackI.hasNext()) {
            String s = stackI.next();
            StdOut.print(s);
        }
        /*********************************************************************/

        /*********************** 出栈入栈测试 *********************************/
        LinkedListWIthGenerics<Integer> intStack = new LinkedListWIthGenerics<Integer>();
        intStack.print();

        while (!StdIn.isEmpty()) {
            int item = StdIn.readInt();
            if (item == -1) {
                intStack.pop();
                intStack.print();
            } else {
                intStack.push(item);
                intStack.print();
            }
        }
        /*********************************************************************/
    }

    private void print() {
        Node cur = first;
        while (cur != null) {
            StdOut.print(cur.item + " ");
            cur = cur.next;
        }
        StdOut.println();
    }
}
