package Week3_Elementary_Sort;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class _14_Quick_Sort_Sedgewick_Version {

    public static void sort(int[] arr) {
        StdRandom.shuffle(arr); // 为了防止最坏情况发生（输入数组为有序的），提前打乱数组
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {

        if (hi <= lo)
            return;
        int j = partition(arr, lo, hi); // 切分
        sort(arr, lo, j - 1); // 将左半部分a[lo .. j-1]排序
        sort(arr, j + 1, hi); // 将右半部分a[j+1 .. hi]排序
    }

    private static int partition(int[] arr, int lo, int hi) {

        int i = lo, j = hi + 1; // 创建左右扫描指针
        int pivot = arr[lo]; // 选择最左侧元素为pivot
        while (true) {
            while (arr[++i] < pivot) // 等同于 while (arr[++i] < pivot && i != hi) continue;
                if (i == hi)
                    break;
            while (pivot < arr[--j])
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(arr, i, j);
        }
        exch(arr, lo, j); // 此时，pivot在最左侧，j指向一个应当在左侧的元素。交换pivot和j指向元素的位置
        return j; // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    // 三向切分的快速排序
    private static void threeWaySplit(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        // 初始化less than，greater than和i指针
        int lt = lo, i = lo + 1, gt = hi;
        int pivot = arr[lo];
        while (i <= gt) {
            if (arr[i] < pivot) {
                exch(arr, i++, lt++);
            } else if (arr[i] > pivot) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        } // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        threeWaySplit(arr, lo, lt - 1);
        threeWaySplit(arr, gt + 1, hi);
    }

    public static void main(String[] args) {

        Stopwatch myStopwatch = new Stopwatch();

        // 生成测试数组
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniformInt(0, 100);
        }

        sort(arr, 0, arr.length - 1);
        threeWaySplit(arr, 0, arr.length - 1);

        StdArrayIO.print(arr); // 打印测试结果

        StdOut.println("It takes " + myStopwatch.elapsedTime() + " seconds");
    }

}
