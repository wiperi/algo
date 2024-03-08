package Sort.Merge_Sort;

public class _12_MG_CuiVer {

    class Tuple {
        int[] left;
        int[] right;
    }

    public int[] sortArray(int[] nums) {

        if (nums.length == 1) return nums;

        Tuple t = split(nums);

        return merge(sortArray(t.left), sortArray(t.right));
    }

    Tuple split(int[] a) {
        int mid = (a.length - 1) / 2;

        int[] left = new int[mid + 1];
        int[] right = new int[a.length - left.length];

        int head = 0, tail = a.length - 1;
        while (head < tail) {
            left[head] = a[head];
            right[tail - (mid + 1)] = a[tail];

            head++;
            tail--;
        }
        if (head == tail) left[head] = a[head];

        Tuple t = new Tuple();
        t.left = left;
        t.right = right;

        return t;
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
            while (j < right.length)
                ret[cur++] = right[j++];
        } else {
            while (i < left.length)
                ret[cur++] = left[i++];
        }
        return ret;
    }
}