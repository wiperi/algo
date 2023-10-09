import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.algs4.StdArrayIO;

public class man {

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] > target) {
                hi--;
            } else if (nums[lo] + nums[hi] < target) {
                lo++;
            } else {
                if (nums[hi] == nums[lo]) {
                    hi--;
                }
                return new int[] { map.get(nums[lo]), map.get(nums[hi]) };
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] origin = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            origin[i] = nums[i];
        }

        Arrays.parallelSort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] > target) {
                hi--;
            } else if (nums[lo] + nums[hi] < target) {
                lo++;
            } else {
                int[] ret = new int[2];
                ret[0] = search(origin, lo);
                origin[ret[0]]++;
                ret[1] = search(origin, hi);
                return ret;
            }
        }
        return null;
    }

    private static int search(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        arr = twoSum(arr, 6);
        StdArrayIO.print(arr);
    }
}