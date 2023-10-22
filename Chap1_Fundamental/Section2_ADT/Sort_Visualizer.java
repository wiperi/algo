package Chap1_Fundamental.Section2_ADT;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.color.*;

import edu.princeton.cs.algs4.Draw;

@SuppressWarnings("rawtypes")
public class Sort_Visualizer {
    private Draw canva;
    private int maxIndex = 0;
    private int minIndex = 0;
    private double maxGap = 0;
    private double max = 0;
    private double min = 0;

    public Sort_Visualizer(Comparable[] a) {
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

    public void drawColumn(Comparable[] a, int i) {
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

    public void drawArray(Comparable[] a) {
        canva.clear();
        int N = a.length;

        for (int i = 0; i < a.length; i++) {
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
        canva.show();
        canva.pause(300);
    }

    public void drawArray(Comparable[] a, int... target) {
        canva.clear();
        int N = a.length;

        for (int i = 0; i < a.length; i++) {
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
        canva.show();
        canva.pause(300);
    }

    public void markColumn(Comparable[] a, Color color, int... target) {
        canva.setPenColor(color);
        int N = a.length;

        for (int i : target) {
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

        canva.show();
        canva.pause(300);
        canva.setPenColor(Draw.BLACK);
    }

    public void markColumn(Comparable[] a, int i) {
        canva.setPenColor(Draw.GREEN);
        int N = a.length;

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

        canva.show();
        canva.pause(300);
        canva.setPenColor(Draw.BLACK);
    }

    public static void main(String[] args) {
        String[] strarr = { "d", "c", "b", "a" };
        Integer[] intarr = { 4, 3, 2, 1, 1, 1, 1, 1, 1, 1 };
        Sort_Visualizer v = new Sort_Visualizer(intarr);
        v.drawArray(intarr);

    }
}
