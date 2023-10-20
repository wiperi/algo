package Chap1_Fundamental.Section4_Algorithm_Analysis.Ex;

import java.util.Arrays;

/**
 * 1.4.16 最接近的一对（一维）。编写一个程序，给定一个含有N 个double 值的数组a[]，在其中找到
 * 一对最接近的值：两者之差（绝对值）最小的两个数。程序在最坏情况下所需的运行时间应该
 * 是线性对数级别的。
 */
public class _16_Closest_Pair {
    public static double[] minimumPair(double[] a) {
        Arrays.parallelSort(a);

        double min = Double.MAX_VALUE; 
        int minIndex1 = -1, minIndex2 = -1;
        for (int i = 1; i < a.length; i++) {
            double difference = Math.abs(a[i]) - Math.abs(a[i - 1]);
            if (difference < min) {
                min = difference;
                minIndex1 = i;
                minIndex2 = i - 1;
            }
        }
        return new double[] { a[minIndex1], a[minIndex2] };
    }
}
