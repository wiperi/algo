package Week2_StacksAndQueues.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizeingArray {
    private String[] arr = new String[1];
    private int head = 0, tail = 0;

    public void enqueue(String item) {

        // 检查arr是否已满
        if (size() == arr.length) {
            resize(arr.length * 2);
        }

        // 入队，移动tail，如果越界则重置
        arr[tail++] = item;
        if (tail == arr.length) {
            tail = 0;
        }
    }

    public String dequeue() {
        // 如果queque为空，抛出异常
        if (isempty()) {
            throw new IllegalArgumentException("Stack is empty.");
        }

        String item = arr[head];
        // 清空head，移动head，如果越界则重置
        arr[head++] = null;
        if (head == arr.length) {
            head = 0;
        }
        // 检测是否应该缩小array size
        if (size() > 0 && size() == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;

    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];

        int i = 0;
        int j = head;
        // 从head位置开始，queque中有几个元素就复制到copy中几次
        for (i = 0; i < size(); i++) {
            copy[i] = arr[j++];
            if (j == arr.length)
                j = 0;
        }
        head = 0;
        tail = i;
        arr = copy;
    }

    public boolean isempty() {
        return size() == 0;
    }

    public int size() {
        // head和tail有前后2种情况，array上有空和非空2种情况，一共4种情况
        if (head == tail) {
            if (arr[head] == null) {
                return 0;
            } else {
                // arr[head] != null;
                return arr.length;
            }
        } else {
            // head != tail
            if (tail > head)
                return tail - head;
            else
                return arr.length + tail - head;
        }
    }

    public void print() {
        // 打印星号
        for (int i = 0; i < 36; i++) {
            StdOut.print("* ");
        }
        StdOut.println();

        StdOut.print("size = " + size());
        StdOut.println(", arrlength = " + arr.length);

        for (int i = 0, j = head; i < size(); i++) {
            StdOut.print(arr[j++] + " ");
            if (j == arr.length) {
                j = 0;
            }
        }
        StdOut.println();

        // 打印星号
        for (int i = 0; i < 36; i++) {
            StdOut.print("* ");
        }
        StdOut.println();
        StdOut.println();
        StdOut.println();
    }

    public static void main(String[] args) {
        ResizeingArray queque = new ResizeingArray();
        queque.print();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("-")) {
                queque.dequeue();
                queque.print();
            } else {
                queque.enqueue(item);
                queque.print();
            }
        }
    }
}
