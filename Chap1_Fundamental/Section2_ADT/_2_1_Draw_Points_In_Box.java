package Chap1_Fundamental.Section2_ADT;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
/**
 * 1.2.2.1 绘制一个矩形，然后随机生成无数个点，统计落在矩形中的点的数量
 */
public class _2_1_Draw_Points_In_Box {
    public static void main(String[] args) {
        // 设置矩形的参数
        double xlo = Double.parseDouble(".2");
        double xhi = Double.parseDouble(".5");
        double ylo = Double.parseDouble(".5");
        double yhi = Double.parseDouble(".6");
        int T = Integer.parseInt("2000");

        // 根据参数绘制矩形
        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        // 随机生成点，如果点在矩形中，计数器加1
        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                c.increment();
            }
            p.draw();
        }
        StdOut.println(c); // 打印落在矩形中的点的数量
        StdOut.println(box.area());
    }
}
