package Chap1_Fundamental.Section4_Algorithm_Analysis.Ex;

import java.util.Arrays;

public class _8_Two_Sum_Linearithmic {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 5, 6, 7, 7, 8, 2, 1, 2, 4, 5 };
        int cnt = twoSum(arr);
        System.out.println(cnt);
    }

    public static int twoSum(int[] arr) {
        int winlength = 0;
        int pairsNum = 0;
        Arrays.sort(arr);
        int i = 0, j = 0;
        while (++j < arr.length) {
            if (arr[i] == arr[j]) {
                if (winlength == 0) {
                    winlength = 2;
                } else {
                    winlength++;
                }
            } else {
                i = j;
                pairsNum += winlength * (winlength - 1) / 2;
                winlength = 0;
            }
        }
        if (winlength != 0)
            pairsNum += winlength * (winlength - 1) / 2;

        return pairsNum;
    }
}
