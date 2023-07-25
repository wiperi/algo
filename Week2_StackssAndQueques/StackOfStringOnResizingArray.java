package Week2_StackssAndQueques;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStringOnResizingArray {
    private String[] arr;
    private int top;

    StackOfStringOnResizingArray() {
        arr = new String[1];
    }

    public boolean isempty() {
        return top == 0 ? true : false;
    }
    
    public void push(String item) {
        if (top == arr.length) {
            resize(2 * arr.length);
        }
        arr[top++] = item;
    }

    public String pop() {
        if (top <= 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        String buffer = arr[--top];
        arr[top] = null;
        if (top > 0 && top == arr.length / 4) {
            resize(arr.length / 2);
        }
        return buffer;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < top; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    public static void main(String[] args) {

        StackOfStringOnResizingArray arr = new StackOfStringOnResizingArray();
        arr.print();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                arr.pop();
                arr.print();
            } else {
                arr.push(item);
                arr.print();
            }
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }
}
