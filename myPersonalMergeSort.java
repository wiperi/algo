import java.util.Arrays;

/**
 * Solutioncopy
 */
public class myPersonalMergeSort {

    public static void sort(int[] a) {
        int[] aux = new int[a.length]; // 一次性分配空间
        mergeSort(a, aux, 0, a.length - 1);
    }

    public static void mergeSort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);

        int left = lo, right = mid + 1;
        System.out.println(left + " " + right); // debug
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            printarr(aux, "aux"); // debug

            int[] temp = { 3, 4, 1, 2 }; // debug
            if (Arrays.equals(a, temp)) { // debug
                int wtf = 0;
            }

            if (left > mid)
                a[i] = aux[right++];
            else if (right > hi)
                a[i] = aux[left++];
            else if (aux[left] < aux[right])
                a[i] = aux[left++];
            else
                a[i] = aux[right++];

            printarr(a, "a"); // debug
        }
    }

    public static void printarr(int[] a, String name) {
        System.out.print(name + ": ");
        for (int ints : a) {
            System.out.print(ints + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}