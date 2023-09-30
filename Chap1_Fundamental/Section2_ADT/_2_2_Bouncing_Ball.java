package Chap1_Fundamental.Section2_ADT;

import edu.princeton.cs.algs4.StdDraw;
/**
 * 绘制一段动画，关于一个会反弹的小球
 */
public class _2_2_Bouncing_Ball {
    public static void main(String[] args) {

        // 设置画布
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(-1.0, 1.0); // 设置x方向min值和max值
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // 设置参数
        double x = 0.2, y = 0.3;        // circle中心坐标
        double vx = 0.012, vy = 0.023;  // x，y方向速度
        double radius = 0.02;           // circle半径

        // main animation loop
        while (true) {

            // 边界碰撞判定
            if (Math.abs(x + vx) + radius > 1.0)
                vx *= -1;
            if (Math.abs(y + vy) + radius > 1.0)
                vy *= -1;

            // 更新坐标
            x += vx;
            y += vy;

            // 重置画布
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(0, 0, 1);

            // 绘制circle
            StdDraw.setPenColor(StdDraw.CYAN);
            StdDraw.filledCircle(x, y, radius);

            // 显示画面并停留一段时间
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

}