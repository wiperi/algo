package Chap1_Fundamental.Section2_ADT;

import javax.swing.JFrame;

import java.awt.Color;
import edu.princeton.cs.algs4.Draw;

@SuppressWarnings("rawtypes")
public class Sort_Visualizer {
    private Draw canva;
    private Comparable[] a;
    private int N;
    private int maxIndex = 0;
    private int minIndex = 0;
    private double maxGap = 0;
    private double max = 0;
    private double min = 0;

    @SuppressWarnings("unchecked")
    public Sort_Visualizer(Comparable[] a) {
        this.a = a;
        this.N = a.length;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[maxIndex]) > 0) {
                maxIndex = i;
            }
            if (a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        if (a[maxIndex] instanceof Number) {
            max = Double.parseDouble(a[maxIndex].toString());
            min = Double.parseDouble(a[minIndex].toString());
            maxGap = max - min;
        } else {
            maxGap = a[maxIndex].compareTo(a[minIndex]);
        }

        canva = new Draw();
        canva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canva.setCanvasSize(500, 500);
        canva.setPenRadius(0.02);
        canva.setXscale(-0.1, 1.1); // 留出20%的空白区域
        canva.setYscale(0, maxGap + 1);
        canva.enableDoubleBuffering();
    }

    @SuppressWarnings("unchecked")
    private void drawColumn(int i) {
        double x = (1.0 * (i + 1)) / N; // 由于下标从0开始，所以是 i + 1
        double y = 0;
        double halfWidth = (((1.0) / N) * 0.9) / 2; // 0.9 为留白参数
        double halfHeight;
        if (a[maxIndex] instanceof Number) {
            halfHeight = Double.parseDouble(a[i].toString()) - min + 1;
        } else {
            halfHeight = a[i].compareTo(a[minIndex]);
        }
        canva.filledRectangle(x, y, halfWidth, halfHeight);
    }

    private void drawColumn(int N, int i, Color markColor) {
        canva.setPenColor(markColor);
        drawColumn(i);
        canva.setPenColor(Draw.BLACK);
    }

    public void drawArray() {
        canva.clear();

        for (int i = 0; i < N; i++) {
            drawColumn(i);
        }
        canva.show();
        canva.pause(300);
    }

    public void drawArray(Boolean clearCanva, Color markColor, int... marked) {
        if (clearCanva)
            canva.clear();

        for (int i = 0; i < N; i++) {
            drawColumn(i);
        }
        for (int i : marked) {
            drawColumn(N, i, markColor);
        }
        canva.show();
        canva.pause(300);
    }

    public void markColumn(Boolean blink, Color markColor, int... marked) {
        canva.setPenColor(markColor);

        for (int i : marked) {
            drawColumn(i);
        }
        canva.show();
        canva.pause(150);

        if (blink) {
            canva.setPenColor(Draw.BLACK);
            for (int i : marked) {
                drawColumn(i);
            }
            canva.show();
            canva.pause(150);
        }
        canva.setPenColor(Draw.BLACK);
    }

    /**
     * bar的高度必须在0到1之间
     * 
     * @param i
     */
    private void showBars(int i) {
        // set up for bar digram
        canva.setXscale(-1, N + 1);
        canva.setPenRadius(0.006);

        canva.setYscale(-a.length + i + 0.8, i + 0.8);

        for (int k = 0; k < a.length; k++) {
            Double y = Double.parseDouble(a[k].toString()) * 0.3;
            Double halfHeight = Double.parseDouble(a[k].toString()) * 0.3;
            canva.filledRectangle(k, y, 0.25, halfHeight);
        }
        canva.show();
    }

    public void key() {
        if (canva.hasNextKeyTyped()) {
            char key = canva.nextKeyTyped();
            if (key == ' ') {
                System.out.println(666);
            }
        }
    }

    public static void main1(String[] args) {
        Integer[] arr = { 1, 1, 1 };
        Sort_Visualizer v = new Sort_Visualizer(arr);
        for (int i = 0; i < arr.length; i++) {
            v.showBars(i);
        }

    }

    public static void main(String[] args) {
        Sort_Visualizer v = new Sort_Visualizer(new Integer[] { 4, 3, 2, 1 });
        v.key();
    }
}
