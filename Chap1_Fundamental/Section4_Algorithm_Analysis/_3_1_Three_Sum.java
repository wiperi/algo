package Chap1_Fundamental.Section4_Algorithm_Analysis;

public class _3_1_Three_Sum {
    // O(N^3)
    public static int count(int[] a) { // 统计和为0的元组的数量
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, -3, -2, -1 };
        System.out.println(count(arr));
    }
}