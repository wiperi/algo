package Chap1_Fundamental.Section4_Algorithm_Analysis;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class _2_3_Doubling_Test_Visual {
    private static double Xscale = 250; // 初始比例
    private static double Yscale = 1;
    private static List<Point2D> list = new ArrayList<Point2D>();

    public static double timeTrial(int N) { // 为处理N 个随机的六位整数的ThreeSum.count() 计时
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformInt(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        @SuppressWarnings("unused")
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) { // 打印运行时间的表格
        initializeCanva();

        for (int N = (int) Xscale; true; N += 30) { // 打印问题规模为N 时程序的用时
            double time = timeTrial(N);
            rescaleIfNecessary(N, time);
            drawPoint(list, N, time);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }

    private static void drawPoint(List<Point2D> list, double n, double time) {
        Point2D point = new Point2D(n, time);
        list.add(point);
        point.draw();
        point.drawTo(list.get(list.size() > 1 ? list.size() - 2 : 0));
    }

    private static void rescaleIfNecessary(int N, double time) {
        if (N > Xscale) {
            rescale(N * 2, Yscale);
        }
        if (time > Yscale) {
            rescale(Xscale, time * 1.3);
        }
        return;
    }

    private static void rescale(double x, double y) {
        if (x != 0) {
            StdDraw.setXscale(0, x);
            Xscale = x;
        }
        if (y != 0) {
            StdDraw.setYscale(0, y);
            Yscale = y;
        }

        StdDraw.clear(Draw.WHITE);
        reDrawLine(list);
    }

    private static void reDrawLine(List<Point2D> list) {
        int i = 0;
        for (Point2D point : list) {
            point.draw();
            if (++i < list.size())
                point.drawTo(list.get(i));
        }
    }

    private static void initializeCanva() {
        StdDraw.setCanvasSize(768, 768);
        StdDraw.setPenColor(Draw.BLUE);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(Xscale * 0.5, Xscale * 2);
        StdDraw.setYscale(0, Yscale);
        StdDraw.clear(Draw.WHITE);
    }
}
