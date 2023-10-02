package Chap1_Fundamental.Section2_ADT;
import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 可视化累加器，继承自Accumulator，加入了可视化功能，每添加一次数据，绘制当前数据的点和平均值的点
 */
public class _4_4_Visual_Accumulator extends Accumulator {
    /**
     * 初始化一个可视化累加器
     * 
     * @param trials 累加的总次数，用于确定X轴的尺度
     * @param max    数据最大值，用于确定y轴的尺度
     */
    _4_4_Visual_Accumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.01);
    }

    /**
     * 添加一个数据，绘制它和当前平均值的点
     * 
     * @param val 添加的数据
     */
    @Override
    public void addDataValue(double val) {
        super.addDataValue(val);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(super.count(), val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(super.count(), super.mean());
    }

    /**
     * 单元测试，添加随机数测试绘制过程
     * 
     * @param args
     */
    public static void main(String[] args) {
        _4_4_Visual_Accumulator vAcc = new _4_4_Visual_Accumulator(1000, 1000);
        for (int i = 0; i < 1000; i++) {
            vAcc.addDataValue(StdRandom.uniformDouble(0, 1000));
        }
    }
}