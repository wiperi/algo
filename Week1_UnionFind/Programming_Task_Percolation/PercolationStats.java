package Week1_UnionFind.Programming_Task_Percolation;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private double[] result;
    private int trials;
    private double mean;
    private double stddev;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {

        // input validate
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trails must > 0");
        }

        this.trials = trials;
        result = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation myP = new Percolation(n);
            while (!myP.percolates()) {
                int randomA = StdRandom.uniformInt(1, n + 1);
                int randomB = StdRandom.uniformInt(1, n + 1);
                myP.open(randomA, randomB);
            }
            result[i] = (double) myP.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean = StdStats.mean(result);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev = StdStats.stddev(result);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - ((1.96 * stddev) / (Math.sqrt(trials)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + ((1.96 * stddev) / (Math.sqrt(trials)));
    }

    // test client (see below)
    public static void main(String[] args) {

        Stopwatch myStopwatch = new Stopwatch();
        
        PercolationStats myPS = new PercolationStats(1000, 30);
        StdOut.println(myPS.mean());
        StdOut.println(myPS.stddev());
        StdOut.println(myPS.confidenceLo());
        StdOut.println(myPS.confidenceHi());

        StdOut.println("It takes " + myStopwatch.elapsedTime() + " seconds");
    }
}