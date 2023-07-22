import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStringOnArray {
    private String[] arr;
    private int stackSize;
    private int top = 0;

    StackOfStringOnArray(int n) {
        stackSize = n;
        arr = new String[stackSize];
    }

    public void push(String item) {
        if (top == stackSize) {
            throw new RuntimeException("Stack is full");
        }
        arr[top] = item;
        top++;
    }

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

    public boolean isempty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public static void main(String[] args) {
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
