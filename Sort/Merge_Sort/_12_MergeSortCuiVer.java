package Sort.Merge_Sort;

public class _12_MergeSortCuiVer {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;
        int[][] sub = split(nums);

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
}