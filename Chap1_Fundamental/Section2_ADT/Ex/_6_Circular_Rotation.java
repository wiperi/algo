package Chap1_Fundamental.Section2_ADT.Ex;

import edu.princeton.cs.algs4.StdOut;

/* 1.2.6　 如果字符串s 中的字符循环移动任意位置之后能够得到另一个字符串t，那么s 就被称为t 的回
环变位（circular rotation）。例如，ACTGACG 就是TGACGAC 的一个回环变位，反之亦然。判定这
个条件在基因组序列的研究中是很重要的。编写一个程序检查两个给定的字符串s 和t 是否互为
回环变位。提示：答案只需要一行用到indexOf()、length() 和字符串连接的代码。 */

public class _6_Circular_Rotation {
    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "def";
        StdOut.println(isCircular(s1, t1));

        String s2 = "ijk";
        String t2 = "kij";
        StdOut.println(isCircular((s2), t2));
    }

    public static boolean isCircular(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
