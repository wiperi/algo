import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import Chap3_Search.TreeNode;

public class Solution {
    public String[] findRelativeRanks(int[] score) {

        Integer[] rank = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            rank[i] = score[i];
        }
        Arrays.sort(rank, Collections.reverseOrder());
        HashMap<Integer, Integer> scoreToRank = new HashMap<>();
        for (int i = 0; i < rank.length; i++) {
            scoreToRank.put(rank[i], i + 1);
        }

        String[] ret = new String[score.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = scoreToRank.get(score[i]).toString();
            if (scoreToRank.get(score[i]) == 1)
                ret[i] = "Gold Medal";
            if (scoreToRank.get(score[i]) == 2)
                ret[i] = "Silver Medal";
            if (scoreToRank.get(score[i]) == 3)
                ret[i] = "Bronze Medal";
        }

        return ret;

    }

    public int maxDepth(TreeNode root) {
        int[] max = { 0 };
        depth(root, 0, max);
        return max[0];
    }

    private int depth(TreeNode root, int curDepth, int[] max) {
        curDepth++;
        if (root == null) {
            return curDepth--;
        }
        max[0] = Math.max(curDepth, max[0]);
        depth(root.left, curDepth, max);
        depth(root.right, curDepth, max);
        return curDepth--;
    }

    public static int iceBreakingGame(int num, int target) {
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = i + 1;
        }
        a[num - 1] = 0;

        int pre = 0, cur = 0, times = 1;
        while (true) {
            times++;
            pre = cur;
            cur = a[cur];

            if (times == target) {
                times = 0;
                a[pre] = a[cur];
                if (a[cur] == a[a[cur]])
                    return a[cur];
            }
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);

        return 1 + Math.max(leftMax, rightMax);
    }
}