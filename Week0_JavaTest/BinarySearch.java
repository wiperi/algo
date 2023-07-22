package Week0_JavaTest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdArrayIO;
import java.util.Arrays;

/* 
 * 使用重定向
 * 
 * 使用命令提示符(cmd)作为终端环境。
 * 
 * 终端操作如下:
 * C:\Users\15617\Documents\92 My Github\java exercise>javac -cp .;./lib/algs4.jar .\BinarySearch.java
 * 该指令将algs4.jar添加到class path中并编译源代码文件
 * 
 * C:\Users\15617\Documents\92 My Github\java exercise>java -cp .;./lib/algs4.jar BinarySearch ./binary_search_whitelist.txt < ./binary_search_input_file.txt
 * 7
 * 8
 * 9
 * 0
 * 
 */
public class BinarySearch {
        public static int rank(int key, int[] a) { // 数组必须是有序的
                int lo = 0;
                int hi = a.length - 1;
                while (lo <= hi) { // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
                        int mid = lo + (hi - lo) / 2;
                        if (key < a[mid])
                                hi = mid - 1;
                        else if (key > a[mid])
                                lo = mid + 1;
                        else
                                return mid;
                }
                return -1;
        }

        public static void main(String[] args) {
                int[] whitelist = new In(args[0]).readAllInts();
                Arrays.sort(whitelist);
                while (!StdIn.isEmpty()) { // 读取键值，如果不存在于白名单中则将其打印
                        int key = StdIn.readInt();
                        if (rank(key, whitelist) < 0)
                                StdOut.println(key);
                }
        }
}
