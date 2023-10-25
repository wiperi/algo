package Chap2_Sort.Section1_Elementary_Sort;

@SuppressWarnings("rawtypes")
public class _6_Shell extends Template {

    public static void sort(Comparable[] a) { // 将a[]按升序排列
        int N = a.length;
        int gap = 1;
        while (gap < N / 3)
            gap = 3 * gap + 1; // 1, 4, 13, 40, 121, 364, 1093, ...

        while (gap >= 1) { // 将数组变为h有序
            for (int i = gap; i < N; i++) { // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= gap && less(a[j], a[j - gap]); j -= gap)
                    exch(a, j, j - gap);
            }
            gap = gap / 3;
        }
    }

    public static void sortSimpleVer(Comparable[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) { // gap: N/2, N/4, N/8 ... 1
            for (int i = gap; i < arr.length; i++) { // from gap to end of arr 进行间隔为gap的插入排序
                Comparable tmp = arr[i];
                for (j = i; j >= gap && less(tmp, arr[j - gap]); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 9, 1, 5, 6, 7, 1, 3, 6, 3, 5, 8, 9 };
        sortSimpleVer(arr);
        show(arr);
    }
}
