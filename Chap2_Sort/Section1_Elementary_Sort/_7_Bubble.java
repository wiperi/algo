package Chap2_Sort.Section1_Elementary_Sort;

@SuppressWarnings("rawtypes")
public class _7_Bubble extends Sort_Template {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[i])) {
                    exch(a, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 6, 1, 6, 1, 4, 2, 5, 2, 6, 8, 9 };
        sort(arr);
        show(arr);
    }
}
