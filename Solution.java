import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

import Chap3_Search.TreeNode;

@SuppressWarnings("unused")
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listq = new ArrayList<>();
        List<TreeNode> listp = new ArrayList<>();
        findPath(root, q, new ArrayList<>(), listq);
        findPath(root, p, new ArrayList<>(), listp);

        int tail = Math.min(listq.size() - 1, listp.size() - 1);
        while (tail >= 0) {
            if (listq.get(tail) == listp.get(tail)) return listp.get(tail);
            tail--;
        }
        return root;
    }

    private void findPath(TreeNode root, TreeNode tar, List<TreeNode> path, List<TreeNode> res) {
        if (root == null) return;

        path.add(root);
        if (root == tar) {
            res.addAll(path);
            return;
        }

        findPath(root.left, tar, path, res);
        findPath(root.right, tar, path, res);

        path.remove(path.size() - 1);
    }
}

class searchInsertclass {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;

        int lo = 0, hi = nums.length - 1;

        int mid = 0, midval = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            midval = nums[mid];

            if (target == midval)
                return mid;
            else if (target > midval)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        if (target > midval)
            return lo;
        else
            return hi;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[maxRow][maxCol]) return false;

        int lo = 0, hi = maxRow;
        int mid = 0, midval = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            midval = matrix[mid][0];

            if (target == midval) return true;
            if (target > midval)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        if (target < midval)
            return searchRow(matrix[mid - 1], target);
        else
            return searchRow(matrix[mid], target);
    }

    private boolean searchRow(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int mid = 0, midval = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            midval = nums[mid];

            if (target == midval) return true;
            if (target > midval)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }
}

class Maxpathsum {
    int globalMax = 0;

    public int maxPathSum(TreeNode root) {
        maxPathSumAux(root);
        return globalMax;
    }

    public int maxPathSumAux(TreeNode root) {
        if (root == null) return 0;

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int innerMax = root.val + Math.max(0, left) + Math.max(0, right);
        if (innerMax > globalMax) globalMax = innerMax;

        int outerMax = root.val + Math.max(0, Math.max(left, right));
        return outerMax;
    }
}

class findIslands {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        /*
         * if (is visited) pass mark this as visited; if this node is 1 and it is
         * islolated then it is island
         * 
         * for i in grid: for each direction: try();
         */
        return 0;
    }

    private int bfs(char[][] grid, boolean[][] visited) {
        if (isIsland(grid, visited)) {

        }
    }

    private boolean isIsland(int x, int y, char[][] grid, boolean[][] visited) {
        for i in derection(x, y):
        return false;
    }

    private void derection(int x, int y) {
        int[] res = new int[4];
        
    }

    public static void showGrid(Integer[][] g) {
        int row = g.length;
        int col = g == null ? 0 : g[0].length;
        int totalLen = row * col;
        for (int i = 0; i < totalLen; i++) {
            System.out.print(g[i / col][i % col] + " ");
            if ((i + 1) % col == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        showGrid(matrix);
    }
}