package Chap1_Fundamental.Section4_Algorithm_Analysis.Ex;

/**
 * 1.4.10 修改二分查找算法，使之总是返回和被查找的键匹配的索引最小的元素（且仍然能够保证对数
 * 级别的运行时间）。
 */
public class _10_Binary_Search_Minimum {
    public static int rank(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key > a[mid]) {
                lo = mid + 1;
            } else if (key < a[mid] || (mid > 0 && key == a[mid - 1])) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 4, 5 };
        System.out.println(rank(arr, 1)); // suppose to be 0
    }
}