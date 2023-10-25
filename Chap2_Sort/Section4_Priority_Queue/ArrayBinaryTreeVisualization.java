package Chap2_Sort.Section4_Priority_Queue;

import edu.princeton.cs.algs4.StdDraw;

public class ArrayBinaryTreeVisualization {
    public static void drawArrayBinaryTree(String[] tree) {
        int n = tree.length;
        double canvasWidth = 800.0;
        double canvasHeight = 400.0;
        StdDraw.setCanvasSize((int) canvasWidth, (int) canvasHeight);
        StdDraw.setXscale(0, canvasWidth);
        StdDraw.setYscale(0, canvasHeight);

        // Calculate the width and height of each tree node
        double nodeWidth = canvasWidth / (n + 1);
        double nodeHeight = 40.0;

        // Draw tree nodes and their values
        for (int i = 0; i < n; i++) {
            double x = (i + 1) * nodeWidth;
            double y = canvasHeight - nodeHeight / 2.0;
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(x, y, nodeWidth / 4.0);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(x, y, tree[i]);
        }

        // Draw tree edges
        for (int i = 0; i < n; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            if (leftChildIndex < n) {
                double parentX = (i + 1) * nodeWidth;
                double parentY = canvasHeight - nodeHeight / 2.0;
                double leftChildX = (leftChildIndex + 1) * nodeWidth;
                double leftChildY = canvasHeight - 3 * nodeHeight / 2.0;
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(parentX, parentY, leftChildX, leftChildY);
            }
            if (rightChildIndex < n) {
                double parentX = (i + 1) * nodeWidth;
                double parentY = canvasHeight - nodeHeight / 2.0;
                double rightChildX = (rightChildIndex + 1) * nodeWidth;
                double rightChildY = canvasHeight - 3 * nodeHeight / 2.0;
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(parentX, parentY, rightChildX, rightChildY);
            }
        }

        StdDraw.show();
    }

    public static void main(String[] args) {
        String[] tree = {"A", "B", "C", "D", "E", "F", "G"};
        drawArrayBinaryTree(tree);
    }
}
