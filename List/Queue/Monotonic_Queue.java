package List.Queue;

import java.util.LinkedList;

/**
 * Monotonic queue is a queue that is either strictly monotonically increasing
 * or decreasing.
 * 
 * It is usually for efficiently solving problems involving finding maximum or
 * minimum elements in a sliding window or a subarray.
 */
public class Monotonic_Queue {

    LinkedList<Integer> q = new LinkedList<>();

    public void enqueue(int n) {
        // make sure the queue is strictly decreasing
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
