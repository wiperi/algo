# Quick Sort Note

```java
public class Quick_Sort {

    public static void sort(int[] arr) {
        StdRandom.shuffle(arr); // 为了防止最坏情况发生（输入数组为有序的），提前打乱数组
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {

        if (hi <= lo)
            return;
        int j = partition(arr, lo, hi); // 切分
        sort(arr, lo, j - 1); // 将左半部分a[lo .. j-1]排序
        sort(arr, j + 1, hi); // 将右半部分a[j+1 .. hi]排序
    }
```

This is a example.

```java
    private static int partition(int[] arr, int lo, int hi) {

        int i = lo, j = hi + 1; // 创建左右扫描指针
        int pivot = arr[lo]; // 选择最左侧元素为pivot
        while (true) {
            while (arr[++i] < pivot) // 等同于 while (arr[++i] < pivot && i != hi) continue;
                if (i == hi)
                    break;
            while (pivot < arr[--j])
                if (j == lo)
                    break;
            if (i >= j)
                break;
            transfer(arr, i, j);
        }
        transfer(arr, lo, j); // 此时，pivot在最左侧，j指向一个应当在左侧的元素。交换pivot和j指向元素的位置
        return j; // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }
}
```

[![Watch the video](https://img.youtube.com/vi/IBnkwEAForc/default.jpg)](https://youtu.be/IBnkwEAForc)
