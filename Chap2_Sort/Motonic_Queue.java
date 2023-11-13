package Chap2_Sort;

import java.util.LinkedList;

// 单调队列
public class Motonic_Queue {
    LinkedList<Integer> q = new LinkedList<>();

    public void enqueue(int n) {
        while (!q.isEmpty() && n > q.getLast()) {
            q.pollLast();
        }
        q.add(n);
    }

    public void dequeue(int n) {
        if (n == q.getFirst()) {
            q.pollFirst();
        }
    }

    public int max() {
        return q.getFirst();
    }
}
