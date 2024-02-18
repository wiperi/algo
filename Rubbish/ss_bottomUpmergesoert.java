package Rubbish;
/**
 * Solutioncopycopy
 */
@SuppressWarnings("rawtypes")
public class ss_bottomUpmergesoert {

    public static void mergeSortBottomUp(Comparable[] a) {
        int N = a.length;
        for (int size = 1; size < N; size *= 2) {
            System.out.println("size: " + size + " / "); // de
            for (int lo = 0; lo < N - size; lo += 2 * size) {
                System.out.print("lo:" + lo + " "); // de
                merge(a, lo, lo + size - 1, lo + size, Math.min(lo + 2 * size - 1, N - 1));
            }
            System.out.println(); // de
        }
    }

    @SuppressWarnings("unchecked")
    public static void merge(Comparable[] a, int left, int leftEnd, int right, int rightEnd) {
        System.out.printf("merge: %d %d %d %d\n", left, leftEnd, right, rightEnd); // de
        int L = left, R = right;
        Comparable[] aux = new Comparable[rightEnd - left + 1];
        int i = 0;
        while (L <= leftEnd && R <= rightEnd) {
            if (a[L].compareTo(a[R]) < 0) {
                aux[i++] = a[L++];
            } else {
                aux[i++] = a[R++];
            }
        }
        if (L > leftEnd) {
            while (R <= rightEnd) {
                aux[i++] = a[R++];
            }
        } else {
            while (L <= leftEnd) {
                aux[i++] = a[L++];
            }
        }
        System.out.print("aux: "); // de
        for (Comparable comparable : aux) {
            System.out.printf("%d ", comparable); // de
            a[left++] = comparable;
        }
        System.out.println(); // de
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 6, 4, 7, 4, 7, 4, 7, 4, 1, 6, 7, 6, 7, 8, 9, 0, 5, 3, 2 };
        mergeSortBottomUp(a);
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }
    }
}