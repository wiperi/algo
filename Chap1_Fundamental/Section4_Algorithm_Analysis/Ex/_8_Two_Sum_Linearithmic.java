package Chap1_Fundamental.Section4_Algorithm_Analysis.Ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.4.8 编写一个程序，计算输入文件中相等的整数对的数量。如果你的第一个程序是平方级别的，请继
 * 续思考并用Array.sort() 给出一个线性对数级别的解答。
 */
public class _8_Two_Sum_Linearithmic {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 5, 6, 7, 7, 8, 2, 1, 2, 4, 5 };
        System.out.println(twoSum(arr));
        System.out.println(twoSumHashMap(arr));
    }

    /**
     * 该算法使用了sliding window的思想，将数组排序后，使用双指针i,
     * j探测每个相同元素组成的窗口长度。然后计算其中包含的整数对
     * <p>
     * 时间复杂度分析，归并排序的复杂度O(N lnN)，遍历复杂度O(N)，算
     * 法总消耗O(N + N lnN)，增长数量级为O(N lnN)
     * 
     * @param arr 要检查的整数数组
     * @return 数组中相等的整数对的数量
     * 
     */
    public static int twoSum(int[] arr) {
        int winlength = 0;
        int numsOfPairs = 0;
        Arrays.sort(arr);
        int i = 0, j = 0;
        while (++j < arr.length) {
            if (arr[i] == arr[j]) { // 延展窗口
                if (winlength == 0) {
                    winlength = 2;
                } else {
                    winlength++;
                }
            } else { // 重置窗口，并统计上一个窗口中的整数对
                i = j;
                numsOfPairs += winlength * (winlength - 1) / 2; // = C(2, N)
                winlength = 0;
            }
        }
        if (winlength != 0) // edge case
            numsOfPairs += winlength * (winlength - 1) / 2;

        return numsOfPairs;
    }

    // O(n) solution
    private static int twoSumHashMap(int[] values) {
        Map<Integer, Integer> valuesMap = new HashMap<>();
        int equalNumbersCount = 0;

        // 遍历数组，如果元素没有被记录过，向hashmap中添加新记录，如果被记录过，记录次数加1
        for (int i = 0; i < values.length; i++) {
            int count = 0;
            if (valuesMap.containsKey(values[i])) {
                count = valuesMap.get(values[i]);
            }
            count++;
            valuesMap.put(values[i], count);
        }

        for (int numberKey : valuesMap.keySet()) {
            if (valuesMap.get(numberKey) > 1) {
                int n = valuesMap.get(numberKey);
                equalNumbersCount += (n - 1) * n / 2;
            }
        }
        return equalNumbersCount;
    }
}
