package Week1_UnionFind.Programming_Task;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final int gridSize; // the side length of the grid
    private final int virtualTop;
    private final int virtualBottom;
    private boolean[][] grid; // array recording the state of the grid
    private int openSitesCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        uf = new WeightedQuickUnionUF(n * n + 2);
        gridSize = n;
        virtualTop = 0;
        virtualBottom = n * n + 1;
        grid = new boolean[n][n];
        openSitesCount = 0;
    }

    private void validate(int n) {
        if (n > gridSize || n <= 0) {
            throw new IllegalArgumentException("The input number must betweeen 0 to " + gridSize);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(col);
        validate(row);

        // x, y is for grid[][] while site is for unionFind operation
        int x = row - 1, y = col - 1;
        int site = gridSize * (row - 1) + col;

        if (!grid[x][y]) {
            grid[x][y] = true;
            openSitesCount++;

            // test right side
            if (col + 1 <= gridSize && isOpen(row, col + 1)) {
                uf.union(site, site + 1);
            }
            // test left side
            if (col - 1 >= 1 && isOpen(row, col - 1)) {
                uf.union(site, site - 1);
            }
            // test down side
            if (row + 1 > gridSize) {
                uf.union(site, virtualBottom);
            } else if (isOpen(row + 1, col)) {
                uf.union(site, site + gridSize);
            }
            // test top side
            if (row - 1 < 1) {
                uf.union(site, virtualTop);
            } else if (isOpen(row - 1, col)) {
                uf.union(site, site - gridSize);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int x = row - 1, y = col - 1;
        return grid[x][y];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(col);
        validate(row);

        int site = (gridSize * (row - 1)) + col;
        return uf.find(virtualTop) == uf.find(site);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSitesCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    // test client (optional)
    public static void main(String[] args) {
        
        double[] result = new double[100];

        for (int i = 0; i < 100; i++) {
            Percolation myPer = new Percolation(5);
            while (!myPer.percolates()) {
                int randomA = StdRandom.uniformInt(1, myPer.gridSize + 1);
                int randomB = StdRandom.uniformInt(1, myPer.gridSize + 1);
                myPer.open(randomA, randomB);
                StdOut.println(randomA + " " + randomB);
            }
            result[i] = (double) myPer.openSitesCount / (myPer.gridSize * myPer.gridSize);
        }
        StdOut.println(StdStats.mean(result));
    }
}