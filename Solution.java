import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.RowFilter.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import C_Data_Structure.Graph;
import Chap3_Search.Binary_Tree.Node;
import edu.princeton.cs.algs4.In;

@SuppressWarnings("unused")
public class Solution {

    class greedy {

        public int maxProfit(int[] prices) {
            // find the minimum day
            int minval = prices[0], minindex = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minval) {
                    minval = prices[i];
                    minindex = i;
                }
            }

            if (minindex == prices.length - 1) return 0;

            int maxval = prices[minindex + 1], maxindex = minindex + 1;
            for (int i = minindex + 1; i < prices.length; i++) {
                if (prices[i] > maxval) {
                    maxval = prices[i];
                    maxindex = i;
                }
            }

            return maxval - minval;
        }
    }

    class MinStack {
        class Pair {
            int val;
            int min;

            Pair(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        Stack<Pair> stack = new Stack<>();

        public MinStack() {}

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Pair(val, val));
            } else {
                stack.push(new Pair(val, val < getMin() ? val : getMin()));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() { return stack.peek().min; }
    }

    class rotten_tomato {
        public int orangesRotting(int[][] grid) {
            int nrow = grid.length;
            int ncol = grid[0].length;

            int rot_x = -1, rot_y = -1;
            int fresh = 0;
            boolean[][] path = new boolean[nrow][ncol];
            for (int i = 0; i < nrow; i++) {
                for (int j = 0; j < ncol; j++) {
                    if (grid[i][j] == 1) fresh++;
                    if (grid[i][j] == 2) {
                        rot_x = i;
                        rot_y = j;
                    }
                }
            }
            int numOfrottened = dfs(grid, path, 0, nrow, ncol, rot_x, rot_y) - 1;
            return numOfrottened < fresh ? -1 : maxLevel;
        }

        int maxLevel = 0;

        private int dfs(int[][] grid, boolean[][] path, int level, int nrow, int ncol, int row, int col) {
            if (row < 0 || row >= nrow || col < 0 || col >= ncol || path[row][col] == true || grid[row][col] == 0)
                return 0;
            int res = 1;
            path[row][col] = true;
            res += dfs(grid, path, level + 1, nrow, ncol, row, col - 1); // Left
            res += dfs(grid, path, level + 1, nrow, ncol, row + 1, col); // Down
            res += dfs(grid, path, level + 1, nrow, ncol, row - 1, col); // Up
            res += dfs(grid, path, level + 1, nrow, ncol, row, col + 1); // Right
            maxLevel = Math.max(level, maxLevel);
            return res;
        }
    }

    class dfs_for_graph {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            dfs(graph, 0);
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        private void dfs(int[][] graph, int s) {
            path.add(s);

            if (s == graph.length - 1) { // reach the end
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i : graph[s]) {
                dfs(graph, i);
            }
            path.removeLast();
        }
    }

    class mhs {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            int minHeight = Integer.MAX_VALUE;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < edges.length; i++) {
                int curHeight = getHeight(edges, i);
                if (curHeight < minHeight) {
                    minHeight = curHeight;
                    res.clear();
                }
                if (curHeight == minHeight) res.add(i);
            }
            return res;
        }

        private int getHeight(int[][] edges, int v) {
            int maxSubHeight = 0;
            for (int i : edges[v]) {
                int subHeight = getHeight(edges, i);
                if (subHeight > maxSubHeight) maxSubHeight = subHeight;
            }
            return 1 + maxSubHeight;
        }
    }

    public static void main(String[] args) {}
}