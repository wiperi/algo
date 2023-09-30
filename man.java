import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

// 表1.1.20 StdDraw 绘图举例
public class man {

    public static void main(String[] args) {
        Draw canvaA = new Draw();

        canvaA.setCanvasSize(1024, 768);
        canvaA.setPenRadius(.001);
        canvaA.setPenColor(122, 122, 66);

        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformDouble();
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N * 1.3;
            double y = 0;
            double rw = 0.4 / N;
            double rh = a[i] / 3;
            canvaA.filledRectangle(x, y, rw, rh);
        }
    }
}