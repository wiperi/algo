package Chap1_Fundamental.Section2_ADT;

import javax.swing.JFrame;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

/**
 * 可视化一个排序算法，从多个网址读取信息
 */
public class _2_2_Array_Visualization {
    public static void bubbleSortVisual(int[] a) {

        int length = a.length;

        // 设置画布
        Draw canva = new Draw();
        canva.setCanvasSize(500, 500);
        canva.setPenRadius(0.02);
        canva.setScale(0, 1);
        canva.enableDoubleBuffering();

        drawArray(canva, a);
        canva.show();
        canva.pause(500);

        // 排序
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
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
        canva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private static void drawArray(Draw canva, int[] a) {
        canva.clear(Draw.WHITE);
        int length = a.length;
        for (int i = 0; i < length; i++) {
            double x = (1.0 * (i + 1)) / (length * 1.2);
            double y = 0.0;
            double hwidth = (1.0 / length) * 0.2;
            double hheight = 1.0 * a[i] / 100;
            canva.filledRectangle(x, y, hwidth, hheight);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        // In webIn1 = new
        // In("https://algs4.cs.princeton.edu/11model/tinyAllowlist.txt");
        // int[] arrA = webIn1.readAllInts();

        // int[] arrB = new
        // In("https://algs4.cs.princeton.edu/11model/tinyText.txt").readAllInts();
        int[] arrA = { 77, 66, 55, 44, 33, 22, 11 };

        bubbleSortVisual(arrA);
        StdArrayIO.print(arrA);
    }
}
