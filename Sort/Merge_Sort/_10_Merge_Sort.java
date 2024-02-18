package Sort.Merge_Sort;

import edu.princeton.cs.algs4.StdArrayIO;

public class _10_Merge_Sort {

    public static void mergeSort(int[] arr) {

        /*
         * 算法概述：
         * 
         * 归并排序通过分治的方法，通过递归，将数组不断分为两半，直到不可细分。
         * 然后治之，比较大小，逐层合并
         * 
         * 参考视频：
         * 
         * https://www.youtube.com/watch?v=3j0SWDX4AtU
         * 
         * 时间复杂度 O(n lg n)：
         * 
         * 假设 input = n ，递归二叉树将有 lg n 层。
         * 一次比较操作将每一层中的一个元素填入上一层，所以每一层需要 n 次比较。
         * 所以时间复杂度为 O(n lg n)
         * 
         * 空间复杂度 O(n):
         * 
         * {1,2,3,4}
         *  - {1,2}
         *  - -  {1}{2}
         */

        // 将 arr.length 缓存到 local variable 避免多次调用外部变量
        int length = arr.length;

        // base case 设置递归的终止条件
        if (length <= 1) {
            return;
        }

        /////////////// 将原数组分成两个子数组并赋值 ////////////////////
        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];
        for (int i = 0; i < middle; i++) {
            leftArr[i] = arr[i];
            rightArr[i] = arr[middle + i];
        }
        rightArr[rightArr.length - 1] = arr[length - 1];
        /////////////// 将原数组分成两个子数组并赋值 ////////////////////

        // 递归调用，只考虑最简单的情况便于理解，由于只要传入的数组Size > 1，就会被mergeSort()细分，所以
        // 第一次传入merge()数组的leftArr和rightArr的Size必定为1
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] arr) {


        // 将 arr.length 缓存到 local variable
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        
        int i = 0, l = 0, r = 0; // 为3个数组创建迭代器

        // 当左，右数组都非空时，比较大小，然后一次填入上一层数组中
        while (l < leftSize && r < rightSize) {
            if (leftArr[l] < rightArr[r]) {
                arr[i] = leftArr[l];
                l++;
                i++;
            } else {
                arr[i] = rightArr[r];
                r++;
                i++;
            }
        }
        
        // 此时一个列表为空，将非空列表的剩余部分全部填入上一层数组中
        if (l < leftSize) {
            while (l < leftSize) {
                arr[i] = leftArr[l];
                l++;
                i++;
            }
        } else {
            while (r < rightSize) {
                arr[i] = rightArr[r];
                r++;
                i++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 4, 1, 2, 3 };

        mergeSort(arr);

        StdArrayIO.print(arr);
    }
}
