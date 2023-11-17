package Week3_Elementary_Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _12_MergeSortCuiVerTest {

    @Test
    public void testSortArray() {
        _12_MergeSortCuiVer sorter = new _12_MergeSortCuiVer();

        int[] nums = { 5, 2, 8, 3, 1 };
        int[] sorted = sorter.sortArray(nums);
        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 5, 8 }, sorted);

        int[] nums2 = { 10, 7, 3, 9, 6 };
        int[] sorted2 = sorter.sortArray(nums2);
        Assertions.assertArrayEquals(new int[] { 3, 6, 7, 9, 10 }, sorted2);

        // Add more test cases as needed
    }

    @Test
    public void testSplit() {
        _12_MergeSortCuiVer sorter = new _12_MergeSortCuiVer();

        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[][] subArrays = sorter.split(arr);

        Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, subArrays[0]);
        Assertions.assertArrayEquals(new int[] { 4, 5, 6 }, subArrays[1]);

        int[] arr2 = { 1 };
        int[][] subArrays2 = sorter.split(arr2);

        Assertions.assertArrayEquals(new int[] { 1 }, subArrays2[0]);
        Assertions.assertArrayEquals(new int[] {}, subArrays2[1]);

        // Add more test cases as needed
    }

    @Test
    public void testMerge() {
        _12_MergeSortCuiVer sorter = new _12_MergeSortCuiVer();

        int[] left = { 1, 3, 5 };
        int[] right = { 2, 4, 6 };
        int[] merged = sorter.merge(left, right);

        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, merged);

        int[] left1 = new int[] {};
        int[] right1 = { 2, 4, 6 };
        int[] merged1 = sorter.merge(left1, right1);

        Assertions.assertArrayEquals(new int[] { 2, 4, 6 }, merged1);

        // Add more test cases as needed
    }
}