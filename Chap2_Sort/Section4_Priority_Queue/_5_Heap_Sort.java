package Chap2_Sort.Section4_Priority_Queue;

import edu.princeton.cs.algs4.Heap;

@SuppressWarnings("rawtypes")
public class _5_Heap_Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;

    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    private static boolean less(Comparable m, Comparable n) {
        return m.compareTo(n) < 0;
    }

    private static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a[k], a[k / 2])) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    private static void sink(Comparable[] a, int k) {
        int N = a.length;
        while (2 * k <= N) {
            if (2 * k < N && less(a[2 * k], a[2 * k + 1])) {

            }
        }
    }

    public static void main(String[] args) {
        Heap.sort(args);
    }
}
