package Chap1_Fundamental;

// 
// 1.1.23 为BinarySearch 的测试用例添加一个参数：+ 打印出标准输入中不在白名单上的值；−，则打
// 印出标准输入中在白名单上的值。

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class _15_BinarySearch {

    /**
     * 使用二分查找的方法，检查一个整数值在不在传入的数组中
     * 
     * @param key 要查找的整数
     * @param a   一个数组，必须是有序的
     * @return 如果找到，返回该值在数组中的索引，否则返回{@code -1}
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else // (key == a[mid])
                return mid;
        }
        return -1;
    }

    /**
     * 使用递归方法实现 BinarySearch 并跟踪该方法的调用。每当该方法被调用时，打印出它的参数 lo 和 hi
     * 并按照递归的深度缩进。提示：为递归方法添加一个参数来。
     * 
     * @param key   要查找的整数
     * @param a     目标数组，必须有序
     * @param lo    查找的左边界
     * @param hi    查找的右边界
     * @param depth 保存递归的深度，默认为1
     * @return 如果找到，返回该值在数组中的索引，否则返回{@code -1}
     */
    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        int mid = lo + (hi - lo) / 2;

        // 打印递归信息
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        StdOut.printf("Recursion depth = %d, lo = %d, hi = %d, mid = %d\n", depth, lo, hi, mid);

        if (lo > hi) {
            return -1;
        }

        if (key == a[mid]) {
            return mid;
        } else if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, depth + 1);
        } else {
            return rank(key, a, mid + 1, hi, depth + 1);
        }
    }

    /**
     * Unit test
     * 
     * 读取一个整数，检查它是否在{@code args[0]}提供的文件中
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) { // 读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (args[1] == "+" && rank(key, whitelist) < 0) {
                StdOut.println(key);
            } else if (args[1] == "-" && rank(key, whitelist) != -1) {
                StdOut.println(key);
            }
        }
    }
}
