package Week3_Elementary_Sort;

public class _10_Merge_Sort {

    public static void mergeSort(int[] arr) {

        int length = arr.length;

        // base case
        if (length <= 1) {
            return;
        }

        ///////////////创建两个子数组并赋值////////////////////
        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];
        for (int i = 0; i < middle; i++) {
            leftArr[i] = arr[i];
            rightArr[i] = arr[middle + i];
        }
        rightArr[rightArr.length - 1] = arr[length - 1];
        ///////////////创建两个子数组并赋值////////////////////

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] arr) {

    }

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 1 };

        mergeSort(arr);
    }
}
