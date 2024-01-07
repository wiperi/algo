import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.function.IntToDoubleFunction;

import javax.swing.RowFilter.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import _50_Data_Structure.Graph._10S_Graph;
import _50_Data_Structure.Tree.Binary_Tree.Node;
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

    class rotten {
        int[] dr = new int[] { -1, 0, 1, 0 };
        int[] dc = new int[] { 0, -1, 0, 1 };

        public int orangesRotting(int[][] grid) {
            int R = grid.length, C = grid[0].length;
            Queue<Integer> queue = new ArrayDeque<Integer>();
            Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] == 2) {
                        int code = r * C + c;
                        queue.add(code);
                        depth.put(code, 0);
                    }
                }
            }
            int ans = 0;
            while (!queue.isEmpty()) {
                int code = queue.remove();
                int r = code / C, c = code % C;
                for (int k = 0; k < 4; ++k) { // for 4 direction
                    int row = r + dr[k];
                    int col = c + dc[k];
                    if (0 <= row && row < R && 0 <= col && col < C && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        int newcode = row * C + col;
                        queue.add(newcode);
                        depth.put(newcode, depth.get(code) + 1);
                        ans = depth.get(newcode);
                    }
                }
            }
            for (int[] row : grid) {
                for (int v : row) {
                    if (v == 1) {
                        return -1;
                    }
                }
            }
            return ans;
        }
    }

    class rot {

        int[] rowDiff = new int[] { 1, 0, 0, -1 };
        int[] colDiff = new int[] { 0, 1, -1, 0 };

        public int orangesRotting(int[][] grid) {
            // get rotten source
            int R = grid.length;
            int C = grid[0].length;
            int[] pathTo = new int[R * C];
            int endPoint = -1;
            List<Integer> rottenSource = new ArrayList<>();
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (grid[r][c] == 2) {
                        rottenSource.add(r * C + c);
                    }
                }
            }
            // put source into the que
            Queue<Integer> que = new LinkedList<>();
            for (Integer rotten : rottenSource) {
                que.add(rotten);
                pathTo[rotten] = rotten;
            }
            // start bfs
            while (que.isEmpty() == false) {
                int cur = que.poll();
                int curR = cur / C;
                int curC = cur % C;

                for (int i = 0; i < 4; i++) {
                    int newR = curR + rowDiff[i];
                    int newC = curC + colDiff[i];
                    if (newR >= 0 && newC >= 0 && newR < R && newC < C && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        que.add(newR * C + newC);
                        pathTo[newR * C + newC] = cur;
                    }
                }
                endPoint = cur;
            }
            // check if all the tomatoes is rotten
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (grid[r][c] == 1) {
                        return -1;
                    }
                }
            }
            // return the result
            int level = 0;
            while (pathTo[endPoint] != endPoint) {
                endPoint = pathTo[endPoint];
                level++;
            }
            return level;
        }
    }

    public static void show(int[] a) {
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
    }

    class hasCiecle {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // build the graph
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // dfs the graph, if ther is cycle return false
            visited = new boolean[numCourses];
            count = 0;
            onPath = new boolean[numCourses];
            dfs(graph, 0);
            return res && count == numCourses;
        }

        private void dfs(List<Integer>[] graph, int v) {
            visited[v] = true;
            onPath[v] = true;
            if (onPath[v]) {
                res = false;
                return;
            }
            for (Integer w : graph[v]) {
                if (!visited[w]) {
                    dfs(graph, w);
                }
            }
            onPath[v] = false;
        }

        boolean res;
        int count;
        boolean visited[];
        boolean[] onPath;

        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < prerequisites.length; i++) {
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }
            return graph;
        }
    }

    public static void main(String[] args) {
        hasCiecle h = new Solution().new hasCiecle();
        boolean res = h.canFinish(2, new int[][] { { 1, 0 } });
        System.out.println(res);
    }
}