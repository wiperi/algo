package Week3_Elementary_Sort;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public class _12_Quick_Sort {

    private static void qsort(int[] arr, int l, int r) {

        /*
         * 算法概述：
         * 
         * 快速排序使用递归的分治方法，通过递归将问题规模不断缩小然后解决问题，具体实施过程是：首先确定base condition，当数组为空或者只有一个元素时，返回。
         * 否则，选取数组中的一个值当作pivot，然后将小于pivot的元素放在pivot左边， 大于的放在右边。 然后，分别对pivot两侧的数组进行同样的操作。
         * 
         * 快排和归并排序都采用了递归的分治方法，区别是，归并排序的比较操作发生在递归调用之后， 快排的比较操作发生在递归调用之前。
         */

        // base condition
        if (l >= r) {
            return;
        }

        ///////////////// 移动数组，实现 {a, b, c, pivot, u, v, w} ///////////////
        int pivot = r; // 选取pivot
        int i = l - 1, j = l; // j指针遍历数组，i指针用来从数组左侧开始将小于pivot依次写入。
        while (j != pivot) { // 每次当arr[j] <= arr[pivot]，就交换 i 和 j 指向元素的位置。

            if (arr[j] <= arr[pivot]) {
                i++;
                transfer(arr, i, j);
            }
            j++;
        }
        transfer(arr, i + 1, pivot);
        ///////////////// 移动数组，实现 {a, b, c, pivot, u, v, w} ///////////////

        qsort(arr, 0, i);
        qsort(arr, i + 2, r);
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
        arr[arr.length - 1] = 66;

        qsort(arr, 0, arr.length - 1);

        StdArrayIO.print(arr); // 打印测试结果

        StdOut.println("It takes " + myStopwatch.elapsedTime() + " seconds");

    }
}
