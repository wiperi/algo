package Chap2_Sort;

@SuppressWarnings("rawtypes")
public class _2_Selection extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[i])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 4, 3, 2, 1 };
        sort(arr);
        assert (isSorted(arr));
        show(arr);
    }
}
