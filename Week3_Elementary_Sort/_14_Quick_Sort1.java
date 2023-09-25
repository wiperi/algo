package Week3_Elementary_Sort;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class _14_Quick_Sort1 {
    public static void sort(int[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi); // 切分（请见“快速排序的切分”）
        sort(a, lo, j - 1); // 将左半部分a[lo .. j-1]排序
        sort(a, j + 1, hi); // 将右半部分a[j+1 .. hi]排序
    }

    private static int partition(int[] a, int lo, int hi) { // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo]; // 切分元素
        while (true) { // 扫描左右，检查扫描是否结束并交换元素
            while (a[++i] < v)
                if (i == hi)
                    break;
            while (v < a[--j])
                if (j == lo)
                    break;
            if (i >= j)
                break;
            transfer(a, i, j);
        }
        transfer(a, lo, j); // 将v = a[j]放入正确的位置
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
        int[] arr = { 0, 0, 0, 0, 0, 0, 0 };
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = StdRandom.uniformInt(0, 100);
        // }
        // arr[0] = 33;

        partition(arr, 0, arr.length - 1);

        StdArrayIO.print(arr); // 打印测试结果

        StdOut.println("It takes " + myStopwatch.elapsedTime() + " seconds");
    }
}
