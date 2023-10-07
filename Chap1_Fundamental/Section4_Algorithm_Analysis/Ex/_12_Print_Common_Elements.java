package Chap1_Fundamental.Section4_Algorithm_Analysis.Ex;

import java.util.List;
import java.util.ArrayList;

/**
 * 1.4.12 编写一个程序，有序打印给定的两个有序数组（含有N 个int 值）中的所有公共元素，程序在
 * 最坏情况下所需的运行时间应该和N 成正比。
 */
public class _12_Print_Common_Elements {
    public static void printCommonElements(int[] arr1, int[] arr2) {
        List<Integer> commonElements = new ArrayList<>();

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) { // 双指针
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // arr1[i] == arr2[j]
                commonElements.add(arr1[i]);
                i++;
                j++;
            }
        }
        for (Integer integer : commonElements) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 4, 6, 7, 9, 11, 13, 15, 16, 22, 25, 25 };
        int[] arr2 = { 3, 6, 13, 22, 25 };
        printCommonElements(arr1, arr2);
    }
}
