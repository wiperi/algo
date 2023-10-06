package Chap1_Fundamental.Section4_Algorithm_Analysis;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class _3_1_Three_SumFast {
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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, -3, -2, -1 };
        System.out.println(count(arr));
    }
}
