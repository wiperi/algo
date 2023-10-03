package Chap1_Fundamental.Section3_Bag_Queue_Stack;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;

public class _3_9_Resizeing_Array_Queue<Item> implements Iterable<Item> {
    private Item[] arr = (Item[]) new Object[1];
    private int head = 0, tail = 0;

    public boolean isempty() {
        return size() == 0;
    }

    public int size() { // head和tail有前后2种情况，array上有空和非空2种情况，一共4种情况
        if (head == tail) {
            if (arr[head] == null) {
                return 0;
            } else {
                // (arr[head] != null)
                return arr.length;
            }
        } else {
            // (head != tail)
            if (tail > head)
                return tail - head;
            else
                return arr.length - (head - tail);
        }
    }

    public void enqueue(Item item) {
        if (size() == arr.length) { // 检查arr是否已满
            resize(arr.length * 2);
        }

        arr[tail++] = item; // 入队，移动tail，如果越界则重置
        if (tail == arr.length) {
            tail = 0;
        }
    }

    public Item dequeue() {
        if (isempty()) { // 如果queque为空，抛出异常
            throw new IllegalArgumentException("Stack is empty.");
        }
        Item item = arr[head];
        arr[head++] = null; // 清空head，移动head，如果越界则重置
        if (head == arr.length) {
            head = 0;
        }
        if (size() > 0 && size() == arr.length / 4) { // 检测是否应该缩小array size
            resize(arr.length / 2);
        }
        return item;

    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];

        int i = 0;
        int j = head;
        // 从head位置开始，queque中有几个元素就复制到copy中几次
        for (i = 0; i < size(); i++) {
            temp[i] = arr[j++];
            if (j == arr.length)
                j = 0;
        }
        head = 0;
        tail = i;
        arr = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int remain = size(); // 剩余元素个数
            private int cur = head;

            @Override
            public boolean hasNext() {
                return remain != 0;
            }

            @Override
            public Item next() {
                Item item = arr[cur++];
                if (cur == arr.length)
                    cur = 0;
                remain--;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        _3_9_Resizeing_Array_Queue<String> queque = new _3_9_Resizeing_Array_Queue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                queque.dequeue();
            } else {
                queque.enqueue(item);
            }
        }
        for (String string : queque) {
            System.out.println(string);
        }
    }
}
