package Chap1_Fundamental.Section3_Bag_Queue_Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 定容栈的实现
 */
public class _2_2_Fixed_Capacity_Stack<Item> {
    private Item[] arr;
    private int size = 0;

    /**
     * 创建一个容量固定的下压栈
     * 
     * @param cap 栈的容量
     */
    @SuppressWarnings("unchecked")
    _2_2_Fixed_Capacity_Stack(int cap) {
        // java不支持创建泛型数组，arr = new Item[cap]; is prohibited.
        arr = (Item[]) new Object[cap];
    }

    /**
     * 将一个对象压入栈中
     * 
     * @param item 被压进栈中的对象
     */
    public void push(Item item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        arr[size] = item;
        size++;
    }

    /**
     * 从栈顶弹出一个对象
     * 
     * @return 栈顶的对象
     */
    public Item pop() {
        if (isempty()) {
            return null;
        }
        size--; /////////////////// 为了避免内存浪费，每一次出栈都将数组中的值重置为null，
        Item tmp = arr[size]; // 这样做，java的内存回收机制会自动将该处引用指向的字符
        arr[size] = null; ///////// 串所占用的内存回收，因为目标字符串已经没有显式引用了
        return tmp;
    }

    /**
     * 
     * @return 是否为空
     */
    public boolean isempty() {
        return size == 0;
    }

    /**
     * 
     * @return 是否已满
     */
    public boolean isFull() {
        return arr.length == size;
    }

    /**
     * 
     * @return 当前容量
     */
    public int size() {
        return size;
    }

    /**
     * 单元测试，从标准输入读取字符串入栈，输入 - 号出栈并打印
     * 
     * @param args
     */
    public static void main(String[] args) {
        _2_2_Fixed_Capacity_Stack<String> stack = new _2_2_Fixed_Capacity_Stack<>(20);

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
