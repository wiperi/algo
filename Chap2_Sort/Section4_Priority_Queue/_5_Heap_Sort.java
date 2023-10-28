package Chap2_Sort.Section4_Priority_Queue;

@SuppressWarnings("rawtypes")
public class _5_Heap_Sort {
    public static void sort(Comparable[] a) {
        // 由下至上建堆（大顶堆）
        // 由于叶节点没有子节点，默认为堆有序状态，所以从最后一个由子节点的根节点开始向上层序遍历
        for (int i = parent(a.length - 1); i >= 0; i--) {
            sink(a, a.length, i);
        }

        // 从堆中提取最大元素放到末尾，缩小堆长度
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            exch(a, 0, i);
            n--;

            sink(a, n, 0);
        }
    }

    @SuppressWarnings("unused")
    private static void swim(Comparable[] a, int i) {
        while (parent(i) >= 0 && less(a, parent(i), i)) {
            exch(a, parent(i), i);
            i = parent(i);
        }
    }

    private static void sink(Comparable[] a, int n, int i) {
        while (true) {
            int max = i;
            int left = leftKid(i);
            int right = rightKid(i);
            if (left < n && less(a, max, left)) {
                max = left;
            }
            if (right < n && less(a, max, right)) {
                max = right;
            }
            if (max == i) {
                break;
            }
            exch(a, i, max);
            i = max;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 7, 5, 2, 6, 9, 7 };
        _5_Heap_Sort.sort(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

    /*******************************************************
     * Helper Functions
     *******************************************************/
    private static int leftKid(int i) {
        return 2 * i + 1;
    }

    private static int rightKid(int i) {
        return 2 * i + 2;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
