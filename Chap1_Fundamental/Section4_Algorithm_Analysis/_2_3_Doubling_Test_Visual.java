package Chap1_Fundamental.Section4_Algorithm_Analysis;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class _2_3_Doubling_Test_Visual {
    public static double timeTrial(int N) { // 为处理N 个随机的六位整数的ThreeSum.count() 计时
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformInt(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) { // 打印运行时间的表格
        int inputSize = 250;
        // initialize canva
        Draw canva = new Draw();
        canva.setCanvasSize(1024, 768);
        canva.setPenRadius(0.02);
        canva.setPenColor(Draw.GREEN);
        canva.setXscale(inputSize, inputSize * 40);
        canva.setYscale(0, 2);

        for (int N = inputSize; true; N += 100) { // 打印问题规模为N 时程序的用时
            double time = timeTrial(N);

            // draw points base on N and times
            canva.point(N, time);

            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }

    public static void main1(String[] args) { // 打印运行时间的表格
        int inputSize = (int) Math.log(250);

        // initialize canva
        Draw canva = new Draw();
        canva.setCanvasSize(1024, 768);
        canva.setPenRadius(0.02);
        canva.setPenColor(Draw.GREEN);
        canva.setXscale(inputSize, inputSize * 40);
        canva.setYscale(0, 2);

        for (int N = inputSize; true; N += ((int) Math.log(100))) { // 打印问题规模为N 时程序的用时
            double time = timeTrial(N);

            // draw points base on N and times
            canva.point(N, time);

            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
