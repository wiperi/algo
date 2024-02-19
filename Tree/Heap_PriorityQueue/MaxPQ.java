package Tree.Heap_PriorityQueue;

import org.junit.jupiter.api.Assertions;

/**
 * The {@code MaxPQ} is a priority queue of integers.
 * 
 * <p> MaxPQ Property: </p>
 * 1. The largest key is at the root. <br>
 * 2. The children of node k are 2k and 2k+1. <br>
 * 3. The parent of node k is k/2. <br>
 * 
 * <p> Time Complexity: </p>
 * 1. Insertion: O(log n) <br>
 * 2. Deletion: O(log n) <br>
 * 3. Find max: O(1) <br>
 */
public class MaxPQ {

    // member variables
    private int[] pq;
    private int tail;

    /**
     * Initializes an empty priority queue with the given initial capacity.
     * 
     * @param capacity
     */
    public MaxPQ(int capacity) {
        pq = new int[capacity + 1];
        tail = 0;
    }

    public boolean isEmpty() { return tail == 0; }

    public int size() {
        return tail;
    }

    /**
     * Inserts a new element into the priority queue.
     * 
     * @param x
     */
    public void insert(int x) {
        pq[++tail] = x;
        swim(tail);
    }

    /**
     * Removes the maximum element from the priority queue and returns it.
     * 
     * @return the maximum element in the priority queue
     */
    public int delMax() {
        // swap the first and the last element then sink the first element
        int max = pq[1];
        int temp = pq[1];
        pq[1] = pq[tail];
        pq[tail] = temp;
        pq[tail--] = 0;
        sink(1);
        return max;
    }

    /**
     * 
     * @return the maximum element in the priority queue
     */
    public int max() {
        return pq[1];
    }

    /************************************************************************
     * Private helper methods
     ************************************************************************/
    
    private int leftChild(int k) {
        return 2 * k;
    }

    private int rightChild(int k) {
        return 2 * k + 1;
    }

    private int parent(int k) {
        return k / 2;
    }

    /**
     * Moves the element at index k up the heap until it satisfies the heap
     * property.
     * 
     * @param k the index of the element to be moved up
     */
    private void swim(int k) {
        while (k > 1 && pq[k] > pq[parent(k)]) {
            exch(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * Moves the element at index k down the heap until it satisfies the heap
     * property.
     * 
     * @param k the index of the element to be moved down
     */
    private void sink(int k) {
        while (leftChild(k) <= tail) {
            int child = leftChild(k);
            // find the larger child
            if (child < tail && pq[child] < rightChild(k)) child = rightChild(k);
            if (pq[k] >= pq[child]) break;
            exch(k, child);
            k = child;
        }
    }

    /**
     * Exchanges the elements at indices i and j in the priority queue.
     * 
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // unit test
    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(10);
        pq.insert(1);
        pq.insert(3);
        pq.insert(2);
        pq.insert(4);
        Assertions.assertEquals(4, pq.size());
        Assertions.assertEquals(4, pq.delMax());
        Assertions.assertEquals(3, pq.delMax());
        Assertions.assertEquals(2, pq.delMax());
        Assertions.assertEquals(1, pq.delMax());
        System.out.println("All tests passed.");
    }
}
