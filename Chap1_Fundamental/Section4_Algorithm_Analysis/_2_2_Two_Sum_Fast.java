package Chap1_Fundamental.Section4_Algorithm_Analysis;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class _2_2_Two_Sum_Fast {
    // O(N lnN)
    public static int count(int[] a) { // 计算和为0的整数对的数目
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (BinarySearch.indexOf(a, -a[i]) > i)
                cnt++;
        return cnt;
    }

    /**
     * 1.4.15 快速3-sum。作为热身，使用一个线性级别的算法（而非基于二分查找的线性对数级别的算法）
     * 实现TwoSumFaster 来计算已排序的数组中和为0 的整数对的数量。用相同的思想为3-sum 问题
     * 给出一个平方级别的算法。
     * 
     * @param a
     * @return
     */
    public static int countLinear(int[] a) {
        int lo = 0, hi = a.length - 1;
        int cnt = 0;
        while (lo < hi) {
            int sum = a[lo] + a[hi];
            if (sum > 0) {
                hi--;
            } else if (sum < 0) {
                lo++;
            } else {
                // a[lo] + a[hi] == 0
                cnt++;

                lo++;
                hi--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { -6, -4, -2, -1, -1, 0, 1, 2, 3, 5, 6, 7, 8, 9 };
        System.out.println(countLinear(arr));
    }
}
