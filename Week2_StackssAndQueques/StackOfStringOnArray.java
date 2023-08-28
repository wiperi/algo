package Week2_StackssAndQueques;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * 说明:
 * 
 * 用数组的方式实现栈的数据结构
 */
public class StackOfStringOnArray {
    private String[] arr;
    private int stackSize;

    // 维护一个栈顶指针
    private int top = 0;

    // 类初始化器，创建一个字符串数组
    StackOfStringOnArray(int n) {
        stackSize = n;
        arr = new String[stackSize];
    }

    // 方法：入栈
    // 先入栈再移动栈顶指针
    public void push(String item) {
        if (top == stackSize) {
            throw new RuntimeException("Stack is full");
        }
        arr[top] = item;
        top++;
    }

    // 方法：出栈
    // 向后移动一格栈顶指针，然后出栈。
    public String pop() {
        if (isempty()) {
            return null;
        }

        /*
         * 为了避免内存浪费，每一次出栈都将数组中的值重置为null，这样做，java的内存回收机制会自动将该处引用指向的字符串所占用的内存回收，
         * 因为目标字符串已经没有显式引用了
         */
        top--;
        String buffer = arr[top];
        arr[top] = null;
        return buffer;
    }

    // 方法：检测是否为空
    public boolean isempty() {
        return top == 0;
    }

    // 方法：检测栈的大小
    public int size() {
        return top;
    }

    public static void main(String[] args) {

        /*
         * 单元测试：
         * 
         * 输入任意字符串并压入栈，输入 - 执行出栈操作并打印
         */
        StackOfStringOnArray stack = new StackOfStringOnArray(20);

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
