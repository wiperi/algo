package Chap1_Fundamental.Section2_ADT;

import javax.swing.JFrame;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.In;

/**
 * 排序算法的可视化，从2个网址读取测试数据，使用多线程并行可视化排序
 */
public class _2_2_Sort_Visualization {
    public static void bubbleSortVisual(int[] a) {

        int length = a.length;

        // 设置画布
        Draw canva = new Draw();
        canva.setCanvasSize(500, 500);
        canva.setPenRadius(0.02);
        canva.setScale(0, 1);
        canva.enableDoubleBuffering();

        // 绘制数组的初始状态
        drawArray(canva, a);
        canva.show();
        canva.pause(500);

        // 绘制排序过程
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                drawArray(canva, a, j, j + 1); // 彩色突出将要对比大小的两个元素
                canva.show();
                canva.pause(300);
                if (a[j] > a[j + 1]) {
                    exch(a, j, j + 1);

                    drawArray(canva, a);
                    canva.show();
                    canva.pause(100);
                }
            }
        }
        drawArray(canva, a);
        canva.show();

        canva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 当窗口被关闭后终止程序
    }

    /**
     * 绘制数组，以柱状图的形式绘制
     * 
     * @param canva 绘制的画布
     * @param a     被绘制的数组
     */
    private static void drawArray(Draw canva, int[] a) {
        int length = a.length;
        canva.clear(Draw.WHITE); // 清空画布

        // 设置绘制参数
        double shrinkX = 1.2;
        double shrinkWidth = 0.2;
        double upperBound = 100;

        // 绘制每一个矩形
        for (int i = 0; i < length; i++) {
            double x = (1.0 * (i + 1)) / (length * shrinkX); // shrinkX让x的最大值缩小，防止贴边
            double y = 0.0;
            double hwidth = (1.0 / length) * shrinkWidth; // shrinkWidth防止矩形太宽，相融到一起
            double hheight = 1.0 * a[i] / upperBound; // upperBound将height限制在0到1
            canva.filledRectangle(x, y, hwidth, hheight);
        }
    }

    /**
     * 绘制数组，以柱状图的形式绘制，并彩色突出其中的两个元素
     * 
     * @param canva 绘制的画布
     * @param a     被绘制的数组
     * @param m     彩色突出的元素
     * @param n     彩色突出的元素
     */
    private static void drawArray(Draw canva, int[] a, int m, int n) {
        int length = a.length;
        canva.clear(Draw.WHITE); // 清空画布

        // 设置绘制参数
        double shrinkX = 1.2;
        double shrinkWidth = 0.2;
        double upperBound = 100;

        // 绘制每一个矩形
        for (int i = 0; i < length; i++) {
            if (i == m) {
                canva.setPenColor(Draw.GREEN);
            }
            if (i == n) {
                canva.setPenColor(Draw.CYAN);
            }
            double x = (1.0 * (i + 1)) / (length * shrinkX); // shrinkX让x的最大值缩小，防止贴边
            double y = 0.0;
            double hwidth = (1.0 / length) * shrinkWidth; // shrinkWidth防止矩形太宽，相融到一起
            double hheight = 1.0 * a[i] / upperBound; // upperBound将height限制在0到1
            canva.filledRectangle(x, y, hwidth, hheight);
            canva.setPenColor(Draw.BLACK);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 单元测试，从两个网址读取整数数组，并行进行可视化排序
     * 
     * @param args
     */
    public static void main(String[] args) {

        In webIn = new In("https://algs4.cs.princeton.edu/11model/tinyAllowlist.txt");
        int[] arrA = webIn.readAllInts();

        int[] arrB = new In("https://algs4.cs.princeton.edu/11model/tinyText.txt").readAllInts();

        // 使用多线程同时绘制两个排序过程
        Thread threadA = new Thread(() -> bubbleSortVisual(arrA));
        Thread threadB = new Thread(() -> bubbleSortVisual(arrB));

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
