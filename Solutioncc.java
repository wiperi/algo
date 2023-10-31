public class Solutioncc {
    public int[] sortArray(int[] nums) {
        int[][] sub = split(nums);
        if (sub[0].length == 1) {
            return sub[0];
        }

        return merge(sortArray(sub[0]), sortArray(sub[1]));
    }

    private int[][] split(int[] a) {
        int mid = a.length / 2;
        int[] left = new int[mid];
        int[] right = new int[a.length - left.length];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        int j = 0;
        for (int i = mid; i < a.length; i++) {
            right[j++] = a[i];
        }
        int[][] ret = new int[2][];
        ret[0] = left;
        ret[1] = right;
        for (int ints : ret[0]) {
            System.out.println(ints);
        }
        System.out.println("fenge");
        for (int ints : ret[1]) {
            System.out.println(ints);
        }
        return ret;
    }

    private int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int cur = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ret[cur++] = left[i++];
            } else {
                ret[cur++] = right[j++];
            }
        }
        if (i >= left.length) {
            while (j < right.length) {
                ret[cur++] = right[j++];

            }
        } else {
            while (i < left.length) {
                ret[cur++] = left[i++];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solutioncc s = new Solutioncc();
        int[] ret = s.merge(new int[] { 1, 3 }, new int[] { 2, 4 });
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        s.split(arr);
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}