package Week2_ElementarySorts;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * 排序算法类的模板
 */
public abstract class SortAlgoExample {

    // 将给定的数组排序
    public static void sort(Comparable[] arr) {

    }

    /*
     * 比较数据之间的大小
     * 
     * 大于小于运算符只能比较数字的大小关系，利用Java提供的Comparable接口，
     * 只要数据结构实现了Comparable接口就被看做是Comparable的子类，并且可以通过该接口提供的compareTo方法比较之间的大小
     */
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // 将数据的位置互换
    private static void exch(Comparable[] arr, int i, int j) {
        Comparable flag;
        flag = arr[i];
        arr[i] = arr[j];
        arr[j] = flag;
    }

    // 在单行中打印数组
    private static void show(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++)
            StdOut.print(arr[i] + " ");
        StdOut.println();
    }

    // 测试数组元素是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        // 从标准输入读取字符串，将它们排序并输出
        String[] arr = In.readStrings();
        sort(arr);
        assert isSorted(arr);
        show(arr);
    }
}