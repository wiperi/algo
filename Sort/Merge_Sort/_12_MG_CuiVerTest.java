package Sort.Merge_Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Sort.Merge_Sort._12_MG_CuiVer.Tuple;

public class _12_MG_CuiVerTest {

    @Test
    public void testSortArray() {
        _12_MG_CuiVer sorter = new _12_MG_CuiVer();

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
        _12_MG_CuiVer sorter = new _12_MG_CuiVer();

        int[] arr = { 1, 2, 3, 4, 5, 6 };
        Tuple t = sorter.split(arr);

        Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, t.left);
        Assertions.assertArrayEquals(new int[] { 4, 5, 6 }, t.right);

        int[] arr2 = { 1 };
        Tuple t2 = sorter.split(arr2);

        Assertions.assertArrayEquals(new int[] { 1 }, t2.left);
        Assertions.assertArrayEquals(new int[] {}, t2.right);

        // Add more test cases as needed
    }

    @Test
    public void testMerge() {
        _12_MG_CuiVer sorter = new _12_MG_CuiVer();

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