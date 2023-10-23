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
        canva.setXscale(-0.1, 1.1);
        canva.setYscale(0, maxGap + 1);
        canva.enableDoubleBuffering();
    }

    @SuppressWarnings("unchecked")
    private void drawColumn(int i) {
        double x = (1.0 * (i + 1)) / N;
        double y = 0;
        double halfWidth = (((1.0) / N) * 0.9) / 2;
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

    public static void main(String[] args) {

    }
}
