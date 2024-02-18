package Sort.Quick_Sort;

import edu.princeton.cs.algs4.StdArrayIO;

public class _13_Quick_Sort_BrocodeVer {

    private static void quickSort(int[] arr, int start, int end) {

        if (start >= end) { // base case
            return;
        }

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        
        int pivot = arr[end];
        int i = start - 1, j = start;
        while (j <= end - 1) {
            if (arr[j] < pivot) {
                i++;
                exch(arr, i, j);
            }
            j++;
        }
        i++;
        exch(arr, i, end);

        return i;
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = { 6, 4, 5, 8, 3, 1 };

        quickSort(arr, 0, arr.length - 1);

        StdArrayIO.print(arr);
    }
}
