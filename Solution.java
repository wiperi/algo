import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import Chap3_Search.TreeNode;

public class Solution {
    public static String[] findRelativeRanks(int[] score) {

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
            if (scoreToRank.get(score[i]) == 1) ret[i] = "Gold Medal";
            if (scoreToRank.get(score[i]) == 2) ret[i] = "Silver Medal";
            if (scoreToRank.get(score[i]) == 3) ret[i] = "Bronze Medal";
        }

        return ret;

    }

    public int maxDepth(TreeNode root) {
        int[] max = {0};
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

    public static void main(String[] args) {
        findRelativeRanks(new int[] { 7, 8, 5, 4 });
    }

    public static void show(Comparable[] a) {
        for (Comparable ints : a) {
            System.out.print(ints + " ");
        }
        System.out.println();
    }
}