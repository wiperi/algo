package Sort;

import org.junit.jupiter.api.Assertions;

public class Heap_Sort {

    public void sort(int[] a) {
        // heapify (maxPQ) the array from second last level to the root
        for (int k = parent(a.length - 1); k >= 0; k--) {
            sink(a, a.length - 1, k);
        }
        // extract the max element from the heap, swap it to the end, shrink
        // the heap, and rehepify.
        int i = a.length - 1;
        while (i >= 0) {
            exch(a, 0, i--);
            sink(a, i, 0);
        }
    }

    /************************************************************************
     * Private helper methods
     ************************************************************************/

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    /**
     * Moves the element at index k down the heap until it satisfies the heap
     * property.
     * 
     * @param k    the index of the element to be moved down
     * @param tail the index of the last element in the heap
     */
    private void sink(int[] a, int tail, int k) {
        while (leftChild(k) <= tail) {

            // find the larger child
            int child = leftChild(k);
            if (rightChild(k) <= tail && a[child] < a[rightChild(k)]) child = rightChild(k);

            if (a[k] >= a[child]) break;
            exch(a, k, child);
            k = child;
        }
    }

    /**
     * Exchanges the elements at indices i and j in the priority queue.
     * 
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // unit test
    public static void main(String[] args) {
        int[] a = { 4, 3, 1, 7, 6, 3, 9, 8, 5, 2 };
        Heap_Sort heap = new Heap_Sort();
        heap.sort(a);
        int[] expected = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
        Assertions.assertArrayEquals(expected, a);
        System.out.println("Passed all test cases!");
    }
}
