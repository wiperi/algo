package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Ghraph_Traversal {
    public static void dfs(int[][] grid) {

    }

    public static void bfs(int[][] grid) {
        int nrow = grid.length;
        int ncol = grid[0].length;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        while (!que.isEmpty()) {
            int index = que.poll();
            int row = index / nrow;
            int col = index % nrow;
            grid[row][col] = 1;
            showGrid(grid);

            if (row + 1 < nrow && grid[row + 1][col] != 1) {
                que.add((row + 1) * nrow + col);
            }
            if (row - 1 >= 0 && grid[row - 1][col] != 1) {
                que.add((row - 1) * nrow + col);
            }
            if (col + 1 < ncol && grid[row][col + 1] != 1) {
                que.add(row * nrow + col + 1);
            }
            if (col - 1 >= 0 && grid[row][col - 1] != 1) {
                que.add(row * nrow + col - 1);
            }
        }
    }

    public static void showGrid(int[][] g) {
        int row = g.length;
        int col = g == null ? 0 : g[0].length;
        int totalLen = row * col;
        for (int i = 0; i < totalLen; i++) {
            System.out.print(g[i / col][i % col] + " ");
            if ((i + 1) % col == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] g = new int[3][3];
        bfs(g);
    }
}
