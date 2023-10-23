package Chap2_Sort;

import Chap1_Fundamental.Section2_ADT.Sort_Visualizer;
import edu.princeton.cs.algs4.Draw;

@SuppressWarnings("rawtypes")
public class _2_Selection extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }

    public static void sortVisual(Comparable[] a) {
        Sort_Visualizer v = new Sort_Visualizer(a);
        v.drawArray();

        int N = a.length;
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                v.markColumn(true, Draw.BLUE, j);
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                    v.markColumn(false, Draw.ORANGE, minIndex);
                }
            }
            v.drawArray(true, Draw.GREEN, i, minIndex);
            exch(a, i, minIndex);
            v.drawArray(true, Draw.GREEN, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 4, 5, 6, 7, 4, 3, 2, 1, 4, 5, 7, 6, 4, 3, 5, 9 };
        sortVisual(arr);
        assert (isSorted(arr));
        show(arr);
    }
}
