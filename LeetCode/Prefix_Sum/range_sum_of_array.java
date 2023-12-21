package LeetCode.Prefix_Sum;

public class Range_Sum_Of_Array {
    int[] prefix;

    Range_Sum_Of_Array(int[] nums) {
        prefix = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
    }

    int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }
}
