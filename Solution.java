/**
 * Solution
 */
public class Solution {

    public int subarraySum(int[] nums, int n) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == n)
                    count++;
            }
        }
        return count;
    }
}