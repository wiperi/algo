import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ssgptrecursive3sum {
    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 需要先将数组排序

        nSumHelper(nums, target, n, 0, new ArrayList<>(), result);
        return result;
    }

    private void nSumHelper(int[] nums, int target, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (n == 2) {
            // 对于两个数的情况，使用双指针法
            int left = start;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>(current);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = start; i < nums.length - (n - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue; // 跳过重复元素
                }
                current.add(nums[i]);
                nSumHelper(nums, target - nums[i], n - 1, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ssgptrecursive3sum solution = new ssgptrecursive3sum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        int n = 4;

        List<List<Integer>> result = solution.nSum(nums, target, n);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
