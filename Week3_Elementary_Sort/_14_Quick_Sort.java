package Week3_Elementary_Sort;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class _14_Quick_Sort {

    public static void main(String[] args) {

        int[] arr = { 1, 6, 5, 4, 3, 2, 0 };

        partition(arr, 0, arr.length - 1);

        StdArrayIO.print(arr);
    }

    private static void partition(int[] arr, int lo, int hi) {
        int pivot = 1;

        int i = lo, j = hi;
        while (i < j && i < hi && j > lo) {
            if (arr[i] >= pivot && arr[j] <= pivot) {
                transfer(arr, i, j);
                i++;
                j--;
            } else if (arr[i] < pivot && arr[j] > pivot) {
                i++;
                j--;
            } else {
                i++;
            }
        }
    }

    private static void transfer(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}