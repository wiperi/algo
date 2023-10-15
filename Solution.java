import java.util.HashMap;

/**
 * Solution
 */
public class Solution {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;

        HashMap<Integer, Integer> window = new HashMap<>();

        for (int i = 0; i < k; i++) {
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
        }
        for (int i : window.values()) {
            if (i > 1)
                return true;
        }

        for (int i = k; i < len; i++) {
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
            window.put(nums[i - k], window.getOrDefault(nums[i], 0) - 1);
            if (window.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 4 }, 3));
    }
}