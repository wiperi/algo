package Chap1_Fundamental.Section2_ADT.Ex;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.1 编写一个Point2D 的用例，从命令行接受一个整数N。在单位正方形中生成N 个随机点，然后计
 * 算两点之间的最近距离。
 */
public class _1_Length_Between_Points {

    public static void main(String[] args) {
        int N = Integer.parseInt("100");

        // 设置画布
        StdDraw.setCanvasSize(1024, 768);
        StdDraw.setPenRadius(.005);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        // 绘制正方形
        double lo = .1, hi = .9;
        Interval1D xInterval = new Interval1D(lo, hi);
        Interval1D yInterval = new Interval1D(lo, hi);
        Interval2D box = new Interval2D(xInterval, yInterval);
        box.draw();

        // 绘制点，每绘制一个点，就计算一遍它和已存在的点的距离
        Point2D[] arr = new Point2D[N];
        double minDistance = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = new Point2D(StdRandom.uniformDouble(lo, hi), StdRandom.uniformDouble(lo, hi));
            arr[i].draw();

            for (int j = 0; j < i; j++) {
                if (i == 1) {
                    minDistance = arr[i].distanceTo(arr[j]);
                } else if (arr[i].distanceTo(arr[j]) < minDistance) {
                    minDistance = arr[i].distanceTo(arr[j]);
                }
            }
        }
        System.out.println(minDistance);
    }
}