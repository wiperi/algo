package Chap1_Fundamental.Section4_Algorithm_Analysis;

public class _2_1_Two_Sum {
    // O(N^2)
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] + a[j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, -3, -2, -1 };
        System.out.println(count(arr));
    }
}
