package Week3_Elementary_Sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Assertions;

public class _12_MergeSortCuiVer {
    public int[] sortArray(int[] nums) {
        int[][] sub = split(nums);
        if (sub[0].length == 1 && sub[1].length == 0) {
            return sub[0];
        }
        return merge(sortArray(sub[0]), sortArray(sub[1]));
    }

    int[][] split(int[] a) {
        int mid = (a.length - 1) / 2;
        int[] left = new int[mid + 1];
        int[] right = new int[a.length - left.length];
        for (int i = 0; i <= mid; i++) {
            left[i] = a[i];
        }
        int j = 0;
        for (int i = mid + 1; i < a.length; i++) {
            right[j++] = a[i];
        }
        int[][] ret = new int[2][];
        ret[0] = left;
        ret[1] = right;
        return ret;
    }

    int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int cur = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                ret[cur++] = left[i++];
            else
                ret[cur++] = right[j++];
        }
        if (i == left.length) {
            while (j < right.length) ret[cur++] = right[j++];
        } else {
            while (i < left.length) ret[cur++] = left[i++];
        }
        return ret;
    }

    public static void main(String[] args) {
        _12_MergeSortCuiVer s = new _12_MergeSortCuiVer();
        s.testMerge();
        s.testSplit();

        System.out.println();

        s.testSortArray();
    }

    public static void show(int[] a) {
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
    }

    protected void testMerge() {
        int[] left = { 1, 3, 5 };
        int[] right = { 2, 4, 6 };
        int[] merged = merge(left, right);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, merged);
    }

    protected void testSplit() {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[][] subArrays = split(arr);

        System.out.println("Subarray 1:");
        show(subArrays[0]);

        System.out.println("Subarray 2:");
        show(subArrays[1]);
    }

    public void testSortArray() {
        _12_MergeSortCuiVer sorter = new _12_MergeSortCuiVer();

        int[] nums = { 5, 2, 8, 3, 1 };
        int[] sorted = sorter.sortArray(nums);
        System.out.println("sorted:");
        show(sorted);
        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 5, 8 }, sorted);

        int[] nums2 = { 10, 7, 3, 9, 6 };
        int[] sorted2 = sorter.sortArray(nums2);
        Assertions.assertArrayEquals(new int[] { 3, 6, 7, 9, 10 }, sorted2);

        // Add more test cases as needed
    }
}