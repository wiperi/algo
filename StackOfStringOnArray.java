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
            return;
        }
        arr[top] = item;
        top++;
    }

    public String pop() {
        if (isempty()) {
            return null;
        }
        top--;
        String buffer = arr[top];
        arr[top] = null;
        return buffer;
    }

    public boolean isempty() {
        return (top == 0 && arr[top] == null) ? true : false;
    }

    public int size() {
        return isempty() ? 0 : top - 1;
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
