package Chap1_Fundamental.Section2_ADT;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 模拟掷骰子的过程，创建一个包含6个Counter元素的数组，每一个Counter代表一面朝上的次数
 */
public class _17_Object_Array {
    public static void main2(String[] args) {
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

    public static void main(String[] args) {
        double xlo = Double.parseDouble(".2");
        double xhi = Double.parseDouble(".5");
        double ylo = Double.parseDouble(".5");
        double yhi = Double.parseDouble(".6");
        int T = Integer.parseInt("2000");
        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();
        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p))
                c.increment();
            else
                p.draw();
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }

}
