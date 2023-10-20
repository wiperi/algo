package Chap1_Fundamental.Section4_Algorithm_Analysis.Ex;

public class _19_Local_Minimum_Matrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 9, 10, 11, 12 },
                { 5, 6, 7, 8 },
                { 1, 2, 3, 4 },
                { 13, 14, 15, 16 }
        };

        int localMin = findLocalMinimum(arr);
        System.out.println("局部最小元素: " + localMin);
    }

    public static int findLocalMinimum(int[][] arr) {
        int n = arr.length;

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            int midRow = (startRow + endRow) / 2;
            int minCol = findMinimumColumn(arr, midRow, startCol, endCol);

            int value = arr[midRow][minCol];

            if (isLocalMinimum(arr, midRow, minCol)) { 
                return value;
            } else if (value > arr[midRow - 1][minCol]) {
                endRow = midRow - 1;
            } else {
                startRow = midRow + 1;
            }
        }

        return -1; // 没有找到局部最小元素
    }

    /**
     * 遍历一行，找到该行中最小的列
     * 
     * @param arr
     * @param row
     * @param startCol
     * @param endCol
     * @return 最小列的索引
     */
    public static int findMinimumColumn(int[][] arr, int row, int startCol, int endCol) {
        int minCol = startCol;
        int minValue = arr[row][startCol];

        for (int col = startCol + 1; col <= endCol; col++) {
            if (arr[row][col] < minValue) {
                minValue = arr[row][col];
                minCol = col;
            }
        }

        return minCol;
    }

    /**
     * 判断一个位置是否是局部最小值
     * 
     * @param arr
     * @param row
     * @param col
     * @return
     */
    public static boolean isLocalMinimum(int[][] arr, int row, int col) {
        int n = arr.length;

        if (row > 0 && arr[row][col] > arr[row - 1][col]) {
            return false;
        }

        if (row < n - 1 && arr[row][col] > arr[row + 1][col]) {
            return false;
        }

        if (col > 0 && arr[row][col] > arr[row][col - 1]) {
            return false;
        }

        if (col < n - 1 && arr[row][col] > arr[row][col + 1]) {
            return false;
        }

        return true;
    }
}
