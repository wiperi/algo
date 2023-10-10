package Chap1_Fundamental.Section4_Algorithm_Analysis;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class _3_2_Three_Sum_Fast {
    // O(N^2 lnN)
    public static int count(int[] a) { // 计算和为０的三元组的数目
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j)
                    cnt++;
        return cnt;
    }

    /**
     * * 1.4.15 快速3-sum。作为热身，使用一个线性级别的算法（而非基于二分查找的线性对数级别的算法）
     * 实现TwoSumFaster 来计算已排序的数组中和为0 的整数对的数量。用相同的思想为3-sum 问题
     * 给出一个平方级别的算法。
     * 
     * @param a
     * @return
     */
    public static int countLinear(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 2; i++) { // 3指针方法
            int lo = i + 1;
            int hi = a.length - 1;
            while (lo < hi) {
                int sum = a[i] + a[lo] + a[hi];
                if (sum == 0) {
                    cnt++;
                    lo++;
                    hi--;
                } else if (sum > 0) {
                    hi--;
                } else {
                    // sum < 0
                    lo++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { -7, -6, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(count(arr));
        System.out.println(countLinear(arr));
    }
}
