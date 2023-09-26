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
            transfer(arr, i, j);
        }
        transfer(arr, lo, j); // 此时，pivot在最左侧，j指向一个应当在左侧的元素。交换pivot和j指向元素的位置
        return j; // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }

    private static void transfer(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {

        Stopwatch myStopwatch = new Stopwatch();

        // 生成测试数组
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniformInt(0, 100);
        }

        sort(arr, 0, arr.length - 1);

        StdArrayIO.print(arr); // 打印测试结果

        StdOut.println("It takes " + myStopwatch.elapsedTime() + " seconds");
    }

        private static void sortQuick3(int[] arr, int lo, int hi) { // 调用此方法的公有方法sort()请见算法2.5
            if (hi <= lo)
                return;
            int lt = lo, i = lo + 1, gt = hi;
            int v = arr[lo];
            while (i <= gt) {
                int cmp = arr[i].compareTo(v);
                if (cmp < 0)
                    transfer(arr, lt++, i++);
                else if (cmp > 0)
                    transfer(arr, i, gt--);
                else
                    i++;
            } // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
            sort(arr, lo, lt - 1);
            sort(arr, gt + 1, hi);
        }
}
