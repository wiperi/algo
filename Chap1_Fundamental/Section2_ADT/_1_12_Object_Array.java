package Chap1_Fundamental.Section2_ADT;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.1.12 模拟掷骰子的过程，创建一个包含6个Counter元素的数组，每一个Counter代表一面朝上的次数，最后统计并打印每一个面向上的次数
 */
public class _1_12_Object_Array {
    public static void main(String[] args) {
        // 设置实验次数
        int rollTimes = 1000000;
        final int SIDES = 6;

        // 初始化数组
        Counter[] facesCounters = new Counter[SIDES];
        for (int i = 0; i < SIDES; i++) {
            facesCounters[i] = new Counter(Integer.toString(i + 1));
        }

        // 模拟掷骰子的过程，记录结果
        for (int i = 0; i < rollTimes; i++) {
            int result = StdRandom.uniformInt(0, SIDES);
            facesCounters[result].increment();
        }

        // 打印结果
        for (int i = 0; i < SIDES; i++) {
            StdOut.println(facesCounters[i].toString() + "'s on top");
        }
    }
}
